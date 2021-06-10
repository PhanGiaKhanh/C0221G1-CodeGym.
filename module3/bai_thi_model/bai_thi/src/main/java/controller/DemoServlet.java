package controller;

import model.bean.Product;
import model.bean.StudentDemo;
import model.service.DemoService;
import model.service.impl.DemoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "DemoServlet", urlPatterns = {"/demo"})
public class DemoServlet extends HttpServlet {
    DemoService demoStudentImpl = new DemoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createDemo(request, response);
                break;
            case "edit":
                editDemo(request, response);
                break;
            case "delete":
                deleteDemo(request, response);
                break;
            case "search":
                searchDemo(request, response);
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
            case "show":
                showElement(request, response);
                break;
            case "edit":
                showEdit(request, response);
                break;
            default:
                showList(request, response);
                break;
        }
    }


    private void createDemo(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String amount = request.getParameter("amount");
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        String c_id = request.getParameter("c_id");
        Product product = new Product(name, price, amount, color, description, c_id);
//        Map<String, String> mapMsg = demoStudentImpl.insert(product);
//        if (mapMsg.isEmpty()) {
//            request.setAttribute("message", "Create succession");
//        } else {
//            request.setAttribute("message", "Create Fail");
//            request.setAttribute("student", product);
//            request.setAttribute("mapMsg", mapMsg);
//        }
//        try {
//            request.getRequestDispatcher("view/student_demo/create.jsp").forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }

    private void editDemo(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String point = request.getParameter("point");
        StudentDemo studentDemo = new StudentDemo(id, name, gender, birthday, email, address, point);
        List<String> errList = demoStudentImpl.updateById(studentDemo);
        if (errList == null) {
            request.setAttribute("message", "Edit success");
            request.setAttribute("student", studentDemo);
        }else {
            request.setAttribute("message",  "Edit Fail");
            request.setAttribute("errList", errList);
            request.setAttribute("student", studentDemo);
        }
        try {
            request.getRequestDispatcher("view/student_demo/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteDemo(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idDel"));
        boolean isDel = demoStudentImpl.deleteById(id);
        if (isDel) {
            request.setAttribute("message", "Successful delete");
            request.setAttribute("students", demoStudentImpl.findAll());
        }else {
            request.setAttribute("message", "Delete failed");
            request.setAttribute("students", demoStudentImpl.findAll());
        }
        try {
            request.getRequestDispatcher("view/student_demo/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchDemo(HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("search");
        List<StudentDemo> list = demoStudentImpl.search(search);
        request.setAttribute("students", list);
        try {
            request.getRequestDispatcher("view/student_demo/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("view/student_demo/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showElement(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        StudentDemo studentDemo = demoStudentImpl.findById(id);
        request.setAttribute("student", studentDemo);
        try {
            request.getRequestDispatcher("view/student_demo/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<StudentDemo> studentDemos = demoStudentImpl.findAll();
        request.setAttribute("students", studentDemos);
        try {
            request.getRequestDispatcher("view/student_demo/list.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("view/404.jsp").forward(request, response);
        }
    }
}
