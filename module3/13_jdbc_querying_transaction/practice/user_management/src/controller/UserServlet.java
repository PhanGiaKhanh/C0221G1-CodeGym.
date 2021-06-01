package controller;

import model.bean.User;
import model.service.UserService;
import model.service.impl.UserImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"", "/users"})
public class UserServlet extends HttpServlet {
    private UserService userDAO = new UserImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                //thuc hanh 1
                createUser(request, response);
                break;
                //end thuc hanh 1
            case "edit":
                updateUser(request, response);
                break;
            case "sortName":
                sortUserName(request, response);
                break;
            case "sortCountry":
                sortUserCountry(request, response);
                break;
            case "search":
                searchCountryUser(request, response);
                break;
            default:
                break;
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(request, response);
                break;

            //#region Thuc Hanh 1
            case "edit":
                showEdit(request, response);
                break;
            //#endregion

            case "delete":
                deleteUser(request, response);
                break;

            //#region Thuc Hanh 2
            case "permision":
                addUserPermision(request, response);
                break;
            //#endregion

            //#region Thuc Hanh 3
            case "test-without-tran":
                testWithoutTran(request, response);
                break;
            //#endregion

            //#region Thuc Hanh 4
            case "test-use-tran":
                testUseTran(request, response);
                break;
            //#endregion

            default:
                showListUser(request, response);
                break;
        }

    }

    //#region Thuc Hanh 4
    private void testUseTran(HttpServletRequest request, HttpServletResponse response) {
        userDAO.insertUpdateUseTransaction();
    }
    //#endregion

    //#region thuc hanh 3
    private void testWithoutTran(HttpServletRequest request, HttpServletResponse response) {
        userDAO.insertUpdateWithoutTransaction();
    }
    //#endregion

    //#region thuc hanh 2
    private void addUserPermision(HttpServletRequest request, HttpServletResponse response) {
        User user = new User("quan", "quan.nguyen@codegym.vn", "vn");
        int[] permision = {1, 2, 4};
        userDAO.addUserTransaction(user, permision);
    }
    //#endregion

    private void searchCountryUser(HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("search");
        List<User> users = userDAO.findByAll();
        List<User> usersSearch = new ArrayList<>();
        for (User user : users){
            if (user.getCountry().contains(search)){
                usersSearch.add(user);
            }
        }
        request.setAttribute("users", usersSearch);
        try {
            request.getRequestDispatcher("user/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDAO.findById(id);
        RequestDispatcher dispatcher;
        if (user == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
            userDAO.remove(id);
            try {
                response.sendRedirect("/users");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void sortUserName(HttpServletRequest request, HttpServletResponse response) {
        List<User> users = userDAO.sortName();
        request.setAttribute("users", users);
        try {
            request.getRequestDispatcher("user/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sortUserCountry(HttpServletRequest request, HttpServletResponse response) {
        List<User> users = userDAO.sortCountry();
        request.setAttribute("users", users);
        try {
            request.getRequestDispatcher("user/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User book = new User(name, email, country);
        userDAO.update(id,book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
//        User existingUser = userDAO.findById(id);
        User existingUser = userDAO.getUserById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
        request.setAttribute("user", existingUser);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void createUser(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User newUser = new User(name, email, country);
//        userDAO.add(newUser);
        try {
            userDAO.insertUserStore(newUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            request.getRequestDispatcher("/user/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/user/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListUser(HttpServletRequest request, HttpServletResponse response) {
        List<User> users = userDAO.findByAll();
        request.setAttribute("users", users);
        try {
            request.getRequestDispatcher("/user/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
//        int id= Integer.parseInt(request.getParameter("id"));
//        Student student = studentService.findById(id);
//        RequestDispatcher requestDispatcher;
//        if (student==null){
//            requestDispatcher = request.getRequestDispatcher("/view/error-404.jsp");
//        }else {
//            requestDispatcher = request.getRequestDispatcher("/view/student/edit.jsp");
//            request.setAttribute("student",student);
//        }
//        try {
//            requestDispatcher.forward(request,response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
