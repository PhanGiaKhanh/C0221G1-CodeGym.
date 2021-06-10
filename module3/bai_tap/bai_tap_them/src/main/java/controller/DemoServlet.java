package controller;

import model.bean.Employee;
import model.service.EmployeeService;
import model.service.impl.EmployeeImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "DemoServlet", urlPatterns = {"", "/demo"})
public class DemoServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeImpl();

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
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        Employee employee = new Employee(code, name, birthday);
        Map<String, String> mapMsg = employeeService.insert(employee);
        if (mapMsg.isEmpty()) {
            request.setAttribute("message", "Create succession");
        } else {
            request.setAttribute("message", "Create Fail");
            request.setAttribute("employee", employee);
            request.setAttribute("mapMsg", mapMsg);
        }
        try {
            request.getRequestDispatcher("view/employee/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void editDemo(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        Employee employee = new Employee(id, code, name, birthday);
        employeeService.updateById(employee);
        request.setAttribute("message", "Edit success");
        request.setAttribute("employee", employee);
        try {
            request.getRequestDispatcher("view/employee/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteDemo(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idDel"));
        boolean check = employeeService.deleteById(id);
        List<Employee> list = employeeService.findAll();
        if (check){
            request.setAttribute("message", "Succession");
            request.setAttribute("employees", list);
        }else {
            request.setAttribute("message", "Delete fail");
            request.setAttribute("employees", list);
        }
        try {
            request.getRequestDispatcher("view/employee/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchDemo(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("view/employee/create.jsp").forward(request, response);
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
        Employee employee = employeeService.findById(id);
        request.setAttribute("employee", employee);
        try {
            request.getRequestDispatcher("view/employee/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employees = employeeService.findAll();
        request.setAttribute("employees", employees);
        try {
            request.getRequestDispatcher("view/employee/list.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("view/404.jsp").forward(request, response);
        }
    }
}
