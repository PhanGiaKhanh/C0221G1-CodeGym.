package controller;

import model.bean.contract.AttachService;
import model.bean.contract.Contract;
import model.bean.contract.ContractDetail;
import model.service.AttachServiceService;
import model.service.ContractDetailService;
import model.service.ContractService;
import model.service.impl.AttachServiceImpl;
import model.service.impl.ContractDetailImpl;
import model.service.impl.ContractImple;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractDetailServlet", urlPatterns = "/contractDetail")
public class ContractDetailServlet extends HttpServlet {
    ContractDetailService contractDetailService = new ContractDetailImpl();
    AttachServiceService attachServiceService = new AttachServiceImpl();
    ContractService contractService = new ContractImple();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": createContract(request, response);break;
//            case "edit": editContract(request, response);break;/
//            case "delete": deleteContract(request, response);break;
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
//            case "edit": showEdit(request, response);break;
//            default: showListEmployee(request, response);break;
        }
    }
    private void createContract(HttpServletRequest request, HttpServletResponse response) {
        int cId = Integer.parseInt(request.getParameter("cId"));
        int aId = Integer.parseInt(request.getParameter("aId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        ContractDetail contractDetail = new ContractDetail( cId, aId, quantity);
        boolean check = contractDetailService.insert(contractDetail);
        if (check){
            request.setAttribute("message", "Thành công");
        }else {
            request.setAttribute("message", "Thất bại");
        }
        List<Contract> contractList = contractService.findAll();
        List<AttachService> attachServiceList = attachServiceService.findAll();
        request.setAttribute("contractList", contractList);
        request.setAttribute("attachList", attachServiceList);
        try {
            request.getRequestDispatcher("view/contract_detail/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        List<ContractDetail> contractDetailList = contractDetailService.findAll();
        List<Contract> contractList = contractService.findAll();
        List<AttachService> attachServiceList = attachServiceService.findAll();
        request.setAttribute("detailList", contractDetailList);
        request.setAttribute("contractList", contractList);
        request.setAttribute("attachList", attachServiceList);
        try {
            request.getRequestDispatcher("view/contract_detail/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
