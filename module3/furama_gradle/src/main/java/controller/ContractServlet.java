package controller;

import model.bean.customer.Customer;
import model.bean.contract.Contract;
import model.bean.employee.Employee;
import model.bean.service.Service;
import model.service.ContractService;
import model.service.CustomerService;
import model.service.EmployeeService;
import model.service.ServiceService;
import model.service.impl.ContractImple;
import model.service.impl.CustomerServiceImpl;
import model.service.impl.EmployeeImple;
import model.service.impl.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractServlet", urlPatterns = "/contracts")
public class ContractServlet extends HttpServlet {
    private ContractService contractService = new ContractImple();
    private CustomerService customerService = new CustomerServiceImpl();
    private EmployeeService employeeService = new EmployeeImple();
    private ServiceService serviceService = new ServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": createContract(request, response);break;
            case "edit": editContract(request, response);break;
            case "delete": deleteContract(request, response);break;
//            case "search": searchContract(request, response);break;
            default: break;
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": showCreate(request, response);break;
//            case "show": showEmployee(request, response);break;
            case "edit": showEdit(request, response);break;
//            default: showListEmployee(request, response);break;
        }
    }


    private void deleteContract(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idDel"));
        contractService.delete(id);
        try {
            response.sendRedirect("/customer-using");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editContract(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String startDate = request.getParameter("start");
        String endDate = request.getParameter("end");
        double deposit = Double.parseDouble(request.getParameter("deposit"));
        double total = Double.parseDouble(request.getParameter("total"));
        int employeeId = Integer.parseInt(request.getParameter("eId"));
        int customerId = Integer.parseInt(request.getParameter("cId"));
        int serviceId = Integer.parseInt(request.getParameter("sId"));
        Contract contract = new Contract(id, startDate, endDate, deposit, total, employeeId, customerId, serviceId);
        boolean isUpdate = contractService.update(contract);
        if(isUpdate) {
            request.setAttribute("message", "Succession");
            request.setAttribute("contract", contract);
        }else {
            request.setAttribute("message", "Fail");
            request.setAttribute("contract", contractService.finById(id));
        }
        try {
            request.getRequestDispatcher("view/contract/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Contract contract = contractService.finById(id);
        request.setAttribute("contract", contract);

        List<Employee> employees = employeeService.findAllEmployee();
        List<Customer> customers = customerService.findAll();
        List<Service> services = serviceService.findAll();
        request.setAttribute("employees", employees);
        request.setAttribute("customers", customers);
        request.setAttribute("services", services);
        try {
            request.getRequestDispatcher("view/contract/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createContract(HttpServletRequest request, HttpServletResponse response) {
        String startDate = request.getParameter("sDate");
        String endDate = request.getParameter("eDate");
        double deposit = Double.parseDouble(request.getParameter("deposit"));
        double total = Double.parseDouble(request.getParameter("total"));
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        int serviceId = Integer.parseInt(request.getParameter("serviceId"));


        Contract contract = new Contract(startDate, endDate, deposit, total, employeeId, customerId, serviceId);
        boolean check = contractService.insert(contract);
        if (check) {
            request.setAttribute("message", "Thành công");
        }else {
            request.setAttribute("message", "Thất bại");
        }
        List<Employee> employees = employeeService.findAllEmployee();
        List<Customer> customers = customerService.findAll();
        List<Service> services = serviceService.findAll();
        request.setAttribute("employees", employees);
        request.setAttribute("customers", customers);
        request.setAttribute("services", services);


        try {
            request.getRequestDispatcher("view/contract/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employees = employeeService.findAllEmployee();
        List<Customer> customers = customerService.findAll();
        List<Service> services = serviceService.findAll();
        request.setAttribute("employees", employees);
        request.setAttribute("customers", customers);
        request.setAttribute("services", services);
        try {
            request.getRequestDispatcher("view/contract/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
