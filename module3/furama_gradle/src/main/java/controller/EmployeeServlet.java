package controller;

import model.bean.employee.*;
import model.service.EmployeeService;
import model.service.impl.EmployeeImple;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employees")
public class EmployeeServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeImple();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": createEmployee(request, response);break;
            case "edit": editEmployee(request, response);break;
            case "delete": deleteEmployee(request, response);break;
            case "search": searchEmployee(request, response);break;
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
            case "create": showCreate(request, response);break;
            case "show": showEmployee(request, response);break;
            case "edit": showEdit(request, response);break;
            default: showListEmployee(request, response);
            break;
        }
    }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("search");
        List<Employee> list = employeeService.searchByName(name);
        request.setAttribute("employees", list);
        try {
            request.getRequestDispatcher("view/employee/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idDel"));
        employeeService.delete(id);
        try {
            response.sendRedirect("/employees");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String card = request.getParameter("card");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int position = Integer.parseInt(request.getParameter("position"));
        int degree = Integer.parseInt(request.getParameter("degree"));
        int division = Integer.parseInt(request.getParameter("division"));
        String userName = request.getParameter("user");
        Employee employee = new Employee(id, name, birthday, card, salary, phone, email, address, position, degree, division, userName);
        boolean check = employeeService.updateById(employee);
        List<Employee> employees = employeeService.findAllEmployee();
        List<Division> divisions = employeeService.findAllDivision();
        List<Position> positions = employeeService.findAllPosition();
        if (check){
            request.setAttribute("message", "Thành công");
            request.setAttribute("employees", employees);
            request.setAttribute("divisions", divisions);
            request.setAttribute("positions", positions);
        }else {
            request.setAttribute("message", "Thất bại");
        }
        try{
            request.getRequestDispatcher("view/employee/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.findEmployee(id);
        List<Division> divisions = employeeService.findAllDivision();
        List<Position> positions = employeeService.findAllPosition();
        request.setAttribute("employee", employee);
        request.setAttribute("divisions", divisions);
        request.setAttribute("positions", positions);
        List<EducationDegree> degrees = employeeService.findAllDegree();
        request.setAttribute("degrees", degrees);
        try {
            request.getRequestDispatcher("view/employee/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.findEmployee(id);
        List<Division> divisions = employeeService.findAllDivision();
        List<Position> positions = employeeService.findAllPosition();
        request.setAttribute("employee", employee);
        request.setAttribute("divisions", divisions);
        request.setAttribute("positions", positions);
        List<EducationDegree> degrees = employeeService.findAllDegree();
        request.setAttribute("degrees", degrees);
        try {
            request.getRequestDispatcher("view/employee/show.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String card = request.getParameter("card");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int position = Integer.parseInt(request.getParameter("position"));
        int degree = Integer.parseInt(request.getParameter("degree"));
        int division = Integer.parseInt(request.getParameter("division"));
        String userName = request.getParameter("user");
        Employee employee = new Employee(name, birthday, card, salary, phone, email, address, position, degree, division, userName);
        boolean isCheck = false;
        User user = new User (userName, "12345678");

        isCheck = employeeService.insertUser(user) &&  employeeService.insert(employee);
        List<Employee> employees = employeeService.findAllEmployee();
        List<Division> divisions = employeeService.findAllDivision();
        List<Position> positions = employeeService.findAllPosition();
        if (isCheck){
            request.setAttribute("message", "New Employee was created");
            request.setAttribute("employees", employees);
            request.setAttribute("divisions", divisions);
            request.setAttribute("positions", positions);
        }else {
            request.setAttribute("message", "New Employee was not created");
        }
        try{
            request.getRequestDispatcher("view/employee/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        List<Division> divisions = employeeService.findAllDivision();
        List<EducationDegree> degrees = employeeService.findAllDegree();
        List<Position> positions = employeeService.findAllPosition();
        request.setAttribute("divisions", divisions);
        request.setAttribute("degrees", degrees);
        request.setAttribute("positions", positions);
        try {
            request.getRequestDispatcher("view/employee/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employees = employeeService.findAllEmployee();
        List<Division> divisions = employeeService.findAllDivision();
        List<Position> positions = employeeService.findAllPosition();
        request.setAttribute("employees", employees);
        request.setAttribute("divisions", divisions);
        request.setAttribute("positions", positions);
        List<EducationDegree> degrees = employeeService.findAllDegree();
        request.setAttribute("degrees", degrees);
        try {
            request.getRequestDispatcher("view/employee/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
