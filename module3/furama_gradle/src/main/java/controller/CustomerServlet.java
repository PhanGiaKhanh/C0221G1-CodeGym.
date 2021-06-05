package controller;

import model.bean.customer.Customer;
import model.bean.customer.CustomerType;
import model.service.CustomerService;
import model.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customers"})
public class CustomerServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            case "edit":
                editCustomer(request, response);
                break;
            case "search":
                showSearch(request, response);
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
                showFormCreate(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            case "show":
                showInfo(request, response);
                break;

            default:
                showListCustomer(request, response);
                break;
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        boolean check = false;
        String name = request.getParameter("name");
        String typeCustomer = request.getParameter("type");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        Customer customer = new Customer(name, birthday, gender, idCard, phone, email, typeCustomer, address);
        check = customerService.insertIntoCustomer(customer);
        if (check) {
            request.setAttribute("message", "Create success");
        }
        try {
            request.getRequestDispatcher("/view/customer/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idDel"));
        customerService.deleteCustomer(id);
        try {
            response.sendRedirect("/customers");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        boolean check = false;
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String typeCustomer = request.getParameter("type");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String idCard = request.getParameter("card");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        Customer customer = new Customer(name, birthday, gender, idCard, phone, email, typeCustomer, address);
        check = customerService.updateById(id, customer);
        if (check) {
            request.setAttribute("message", "Edit success");
        }
        try {
            request.getRequestDispatcher("/view/customer/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.findAll();
        request.setAttribute("customers", customerList);
        try {
                request.getRequestDispatcher("/view/customer/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> stringList = customerService.findType();
        request.setAttribute("list", stringList);
        try {
            request.getRequestDispatcher("/view/customer/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        request.setAttribute("customer", customer);
        List<CustomerType> stringList = customerService.findType();
        request.setAttribute("list", stringList);
        try {
            request.getRequestDispatcher("/view/customer/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showInfo(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        request.setAttribute("customer", customer);
        try {
            request.getRequestDispatcher("/view/customer/show.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showSearch(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("search");
        List<Customer> customerList = customerService.searchByName(name);
        request.setAttribute("customers", customerList);
        try {
            request.getRequestDispatcher("/view/customer/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
