package controller;

import model.bean.Category;
import model.bean.Product;
import model.bean.StudentDemo;
import model.service.ProductService;
import model.service.impl.ProductImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ProductServlet", urlPatterns = {"", "/products"})
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "edit":
                editProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "search":
                searchProduct(request, response);
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
            case "edit":
                showEdit(request, response);
                break;
            default:
                showList(request, response);
                break;
        }
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("search");
        List<Product> list = productService.search(name);
        request.setAttribute("products", list);
        try {
            request.getRequestDispatcher("/view/product/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idDel"));
        boolean isDel = productService.deleteById(id);
        if (isDel) {
            request.setAttribute("message", "Successful delete");
            request.setAttribute("products", productService.findAll());
        }else {
            request.setAttribute("message", "Delete failed");
            request.setAttribute("products", productService.findAll());
        }
        try {
            request.getRequestDispatcher("view/product/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String amount = request.getParameter("amount");
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        String c_id = request.getParameter("c_id");
        Product product = new Product(id, name, price, amount, color, description, c_id);
        boolean isEdit = productService.updateById(product);
        if (isEdit) {
            request.setAttribute("message", "Edit success");
            request.setAttribute("product", product);
        }else {
            request.setAttribute("message",  "Edit Fail");
            request.setAttribute("product", product);
        }
        try {
            request.getRequestDispatcher("view/product/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String amount = request.getParameter("amount");
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        String c_id = request.getParameter("c_id");
        Product product = new Product(name, price, amount, color, description, c_id);
        boolean isCreate = productService.insert(product);
        List<Product> products = productService.findAll();
        List<Category> categories = productService.findAllCategory();
        if(isCreate){
            request.setAttribute("message", "Create succession");
            request.setAttribute("products", products);
            request.setAttribute("categories", categories);
        } else {
            request.setAttribute("message", "Create Fail");
            request.setAttribute("product", product);
        }
        try {
            request.getRequestDispatcher("view/product/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = productService.findAll();
        List<Category> categories = productService.findAllCategory();
        request.setAttribute("products", products);
        request.setAttribute("categories", categories);

        try {
            request.getRequestDispatcher("view/product/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        List<Category> categories = productService.findAllCategory();
        request.setAttribute("categories", categories);
        request.setAttribute("product", product);
        try {
            request.getRequestDispatcher("view/product/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {

        List<Category> categories = productService.findAllCategory();
        request.setAttribute("categories", categories);

        try {
            request.getRequestDispatcher("view/product/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
