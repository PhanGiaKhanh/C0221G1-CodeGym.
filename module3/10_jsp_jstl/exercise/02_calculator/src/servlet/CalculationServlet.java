package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculationServlet", urlPatterns = "/calculation")
public class CalculationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result = null;
        try {
            double firstNumber = Double.parseDouble(request.getParameter("first-number"));
            double secondNumber = Double.parseDouble(request.getParameter("second-number"));
            switch (request.getParameter("choose")) {
                case "add":
                    result = String.valueOf(firstNumber + secondNumber);
                    break;
                case "sub":
                    result = String.valueOf(firstNumber - secondNumber);
                    break;
                case "div":
                    try {
                        if (secondNumber == 0) {
                            throw new Exception("Lỗi chia 0");
                        }
                        result = String.valueOf(firstNumber / secondNumber);
                    }catch (Exception e) {
                        request.setAttribute("result", e.getMessage());
                        request.getRequestDispatcher("result.jsp").forward(request, response);
                    }

                    break;
                case "mut":
                    result = String.valueOf(firstNumber * secondNumber);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + request.getParameter("choose"));
            }
        }catch (Exception e) {
            request.setAttribute("result", "lỗi không nhập");
            request.getRequestDispatcher("result.jsp").forward(request, response);
        }
        request.setAttribute("result", result);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
