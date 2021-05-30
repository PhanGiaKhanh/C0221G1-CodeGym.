package controller;

import model.bean.Customer;
import model.service.CustomerService;
import model.service.impl.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customers"})
public class CustomerServlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "edit":
                updateCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            case "search":
                searchCustomer(request, response);
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
                showCreateCustomer(request, response);
                break;
            case "edit":
                showEditCustomer(request, response);
                break;
            case "show":
                showCustomer(request, response);
                break;
            default:
                listCustomer(request, response);
                break;
        }
    }
    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = customerService.findAll().size() + 1;
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        int idCard = Integer.parseInt(request.getParameter("idCard"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String typeCustomer = request.getParameter("typeCustomer");
        String address = request.getParameter("address");

        Customer customer = this.customerService.findById(id);
        RequestDispatcher dispatcher;
        if (customer == null){
            request.setAttribute("message", "Customer information was not update");
        }else {
            customer.setC_name(name);
            customer.setC_birthday(birthday);
            customer.setC_gender(gender);
            customer.setC_id_card(idCard);
            customer.setC_phone(phone);
            customer.setC_email(email);
            customer.setC_type(typeCustomer);
            customer.setC_address(address);
            request.setAttribute("message", "Customer information was update");
        }

        try {
            request.getRequestDispatcher("view/customer/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        this.customerService.remove(id);
        List<Customer> customers = this.customerService.findAll();
        request.setAttribute("customers", customers);
        try{
            request.getRequestDispatcher("view/customer/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = this.customerService.findById(id);
        request.setAttribute("customer", customer);
        try{
            request.getRequestDispatcher("view/customer/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("search");
        List<Customer> customers = customerService.findByName(search);
        request.setAttribute("customers", customers);
        try {
            request.getRequestDispatcher("view/customer/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
//        STT	Name	Birthday	Gender	Id card	Phone	Email	Type customer	Address	Show	Edit	Delete
        int id = customerService.findAll().size() + 1;
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        int idCard = Integer.parseInt(request.getParameter("idCard"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String typeCustomer = request.getParameter("typeCustomer");
        String address = request.getParameter("address");

        Customer customer = new Customer(id, name, birthday, gender, idCard, phone, email, typeCustomer, address);
        this.customerService.save(customer);
        request.setAttribute("message", "New customer was create");

        try {
            request.getRequestDispatcher("view/customer/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateCustomer(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("view/customer/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = this.customerService.findById(id);
        request.setAttribute("customer", customer);
        try {
            request.getRequestDispatcher("view/customer/show.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> products = customerService.findAll();
        request.setAttribute("p", products);

        try {
            request.getRequestDispatcher("view/customer/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customers = customerService.findAll();
        request.setAttribute("customers", customers);
        try {
            request.getRequestDispatcher("view/customer/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
