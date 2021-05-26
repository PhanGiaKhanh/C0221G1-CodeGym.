import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AppProductServlet", value = "/app_product")
public class AppProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double price = Double.parseDouble(request.getParameter("price"));
        double percent = Double.parseDouble(request.getParameter("percent"));

        double amount = price * percent * 0.01;

        PrintWriter writer = response.getWriter();
        writer.println("<html>" +
                "<h1>Description : "+ request.getParameter("description")+"</h1>" +
                "<h5>List Price: "+price+ "vnd<h5> " +
                "<h5>Discount Percent: "+percent+ "vnd<h5>" +
                "<h5>Discount Amount: "+ amount +"<h5><hr>" +
                "</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
