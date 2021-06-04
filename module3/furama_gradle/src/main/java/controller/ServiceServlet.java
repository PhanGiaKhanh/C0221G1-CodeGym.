package controller;

import javafx.beans.property.IntegerProperty;
import model.bean.service.RentType;
import model.bean.service.Service;
import model.bean.service.ServiceType;
import model.service.ServiceService;
import model.service.impl.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "ServiceServlet", urlPatterns = "/services")
public class ServiceServlet extends javax.servlet.http.HttpServlet {
    private ServiceService serviceService = new ServiceImpl();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createService(request, response);
                break;
            default:
                break;
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(request, response);
                break;
            case "show":
                showInfo(request, response);
                break;
            default:
                showListService(request, response);
                break;
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        List<RentType> rentList = serviceService.findRentType();
        List<ServiceType> typeList = serviceService.findServiceType();
        request.setAttribute("rentList", rentList);
        request.setAttribute("typeList", typeList);
        try {
            request.getRequestDispatcher("view/service/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        int rentType = Integer.parseInt(request.getParameter("rent"));
        int serviceType  = Integer.parseInt(request.getParameter("type"));
        String standardRoom = request.getParameter("standard");
        String description = request.getParameter("description");
        String poolArea = request.getParameter("pool");
        String numberOfFloor = request.getParameter("floor");
        if (standardRoom == ""){
            standardRoom = null;
        }
        if (description == ""){
            description = null;
        }
        if (poolArea == "") {
            poolArea = null;
        }
        if (numberOfFloor == ""){
            numberOfFloor = null;
        }
        Service service = new Service(name, area, cost, maxPeople, rentType, serviceType, standardRoom, description, poolArea, numberOfFloor);
        boolean isCreate = serviceService.insertService(service);

        List<Service> serviceList = serviceService.findAll();
        List<RentType> rentList = serviceService.findRentType();
        List<ServiceType> typeList = serviceService.findServiceType();

        if (isCreate) {
            request.setAttribute("message", "New service was create");
            request.setAttribute("services", serviceList);
            request.setAttribute("rentList", rentList);
            request.setAttribute("typeList", typeList);
        } else {
            request.setAttribute("message", "New service was  not create");
        }
        try {
            request.getRequestDispatcher("view/service/list.jsp").forward(request , response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showInfo(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Service service = serviceService.findById(id);
        List<RentType> rentList = serviceService.findRentType();
        List<ServiceType> typeList = serviceService.findServiceType();
        request.setAttribute("service", service);
        request.setAttribute("rentList", rentList);
        request.setAttribute("typeList", typeList);

        try {
            request.getRequestDispatcher("view/service/show.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListService(HttpServletRequest request, HttpServletResponse response) {
        List<Service> serviceList = serviceService.findAll();
        List<RentType> rentList = serviceService.findRentType();
        List<ServiceType> typeList = serviceService.findServiceType();
        request.setAttribute("services", serviceList);
        request.setAttribute("rentList", rentList);
        request.setAttribute("typeList", typeList);

        try {
            request.getRequestDispatcher("view/service/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
