//package controller;
//
//import model.bean.Customer;
//import model.service.impl.CustomerImpl;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet(name = "CustomerModalServlet", urlPatterns = {"/customer-modal"})
//public class CustomerModalServlet extends HttpServlet {
//    CustomerImpl customerImpl = new CustomerImpl();
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//        switch (action) {
//            case "create":
//                createCustomerForm(request, response);
//                break;
////            case "edit":
////                break;
////            case "delete":
////                break;
////            case "search":
////                break;
//            default:
//                break;
//        }
//    }
//
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//        switch (action) {
//            case "create":
//                createCustomerForm(request, response);
//                break;
//            case "edit":
//                break;
//            case "delete":
//                break;
//            case "search":
//                break;
//            default:
//                listCustomers(request, response);
//                break;
//        }
//    }
//
//    private void listCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Customer> customers = customerImpl.findAll();
//        request.setAttribute("customers", customers);
//        request.getRequestDispatcher("/view/customer/listModal.jsp").forward(request, response);
//    }
////    private void createCustomerForm(HttpServletRequest request, HttpServletResponse response) {
////        int id = customerImpl.getSize()+1;
////        String name = request.getParameter("name");
////        String birthday = request.getParameter("birthday");
////        String gender = request.getParameter("gender");
////        int idCard = Integer.parseInt(request.getParameter("idCard"));
////        int phone = Integer.parseInt(request.getParameter("phone"));
////        String email = request.getParameter("email");
////        String typeCustomer = request.getParameter("typeCustomer");
////        String address = request.getParameter("address");
////
////        Customer customer = new Customer(id, name, birthday, gender, idCard, phone, email, typeCustomer, address);
////        customerImpl.save(customer);
////        List<Customer> customers = customerImpl.findAll();
////
////        request.setAttribute("customers", customers);
////
////        try {
////            request.getRequestDispatcher("view/customer/listModal.jsp").forward(request, response);
////        } catch (ServletException e) {
////            e.printStackTrace();
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////    }
////private void createCustomerForm(HttpServletRequest request, HttpServletResponse response) {
////        int id = customerImpl.getSize()+1;
////        String name = request.getParameter("name");
////        String birthday = request.getParameter("birthday");
////        String gender = request.getParameter("gender");
////        int idCard = Integer.parseInt(request.getParameter("idCard"));
////        int phone = Integer.parseInt(request.getParameter("phone"));
////        String email = request.getParameter("email");
////        String typeCustomer = request.getParameter("typeCustomer");
////        String address = request.getParameter("address");
////
////        Customer customer = new Customer(id, name, birthday, gender, idCard, phone, email, typeCustomer, address);
////    this.customerImpl.save(customer);
////    request.setAttribute("message", "New product was created");
////
////    try {
////        request.getRequestDispatcher("view/customer/listModal.jsp").forward(request, response);
////    } catch (ServletException e) {
////        e.printStackTrace();
////    } catch (IOException e) {
////        e.printStackTrace();
////    }
////}
//
//    private void createCustomerForm(HttpServletRequest request, HttpServletResponse response) {
//        int id = customerImpl.getSize()+1;
//        String name = request.getParameter("name");
//        String birthday = request.getParameter("birthday");
//        String gender = request.getParameter("gender");
//        int idCard = Integer.parseInt(request.getParameter("idCard"));
//        int phone = Integer.parseInt(request.getParameter("phone"));
//        String email = request.getParameter("email");
//        String typeCustomer = request.getParameter("typeCustomer");
//        String address = request.getParameter("address");
//
//        Customer customer = new Customer(id, name, birthday, gender, idCard, phone, email, typeCustomer, address);
//        customerImpl.save(customer);
//        List<Customer> customers = customerImpl.findAll();
//
//        request.setAttribute("customers", customers);
//
//        try {
//            request.getRequestDispatcher("view/customer/listModal.jsp").forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}