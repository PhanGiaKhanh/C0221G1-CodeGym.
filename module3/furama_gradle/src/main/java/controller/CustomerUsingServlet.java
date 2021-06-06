package controller;

import model.bean.contract.AttachService;
import model.bean.contract.ContractDetail;
import model.bean.customer.CustomerUsing;
import model.service.AttachServiceService;
import model.service.ContractDetailService;
import model.service.CustomerUsingService;
import model.service.impl.AttachServiceImpl;
import model.service.impl.ContractDetailImpl;
import model.service.impl.CustomerUsingImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerUsingServlet", urlPatterns = "/customer-using")
public class CustomerUsingServlet extends HttpServlet {
    CustomerUsingService customerUsingService = new CustomerUsingImpl();
    ContractDetailService contractDetailService = new ContractDetailImpl();
    AttachServiceService attachServiceService = new AttachServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
//            case "create": create(request, response);break;
//            case "edit": edit(request, response);break;
//            case "delete": delete(request, response);break;
            case "search": searchCustomerUsing(request, response);break;
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
//            case "create": showCreate(request, response);break;
//            case "show": showElement(request, response);break;
//            case "edit": showEdit(request, response);break;
            default: showList(request, response);
                break;
        }
    }


    private void searchCustomerUsing(HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("search");
        List<CustomerUsing> customerUsings =  customerUsingService.search(search);
        List<ContractDetail> contractDetails = contractDetailService.findAll();
        List<AttachService> attachServices = attachServiceService.findAll();
        request.setAttribute("customerUsings", customerUsings);
        request.setAttribute("contractDetails", contractDetails);
        request.setAttribute("attachServices", attachServices);
        try {
            request.getRequestDispatcher("view/customer_using/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerUsing> customerUsings =  customerUsingService.findAll();
        List<ContractDetail> contractDetails = contractDetailService.findAll();
        List<AttachService> attachServices = attachServiceService.findAll();
        request.setAttribute("customerUsings", customerUsings);
        request.setAttribute("contractDetails", contractDetails);
        request.setAttribute("attachServices", attachServices);
        try {
            request.getRequestDispatcher("view/customer_using/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
