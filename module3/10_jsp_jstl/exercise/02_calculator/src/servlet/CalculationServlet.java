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
        double firstNumber = Double.parseDouble(request.getParameter("first-number"));
        double secondNumber = Double.parseDouble(request.getParameter("second-number"));
        String result;
        switch (request.getParameter("choose")) {
            case "add": result = String.valueOf(firstNumber + secondNumber); break;
            case "sub": result = String.valueOf(firstNumber - secondNumber); break;
            case "div": if (secondNumber == 0) {
                result = "phép tính sai";
            }else {
                result = String.valueOf(firstNumber / secondNumber);
            }break;
            case "mut": result = String.valueOf(firstNumber * secondNumber);break;
            default:
                throw new IllegalStateException("Unexpected value: " + request.getParameter("choose"));
        }

        request.setAttribute("result", result);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
