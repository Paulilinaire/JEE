package servlets;

import model.Product;
import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/imageServlet")
public class ImageServlet extends HttpServlet {

    private ProductDAO productDAO;

    public void init() {

        productDAO = new ProductDAO();

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.findById(id);
        response.setContentType("image/png");
        OutputStream out = response.getOutputStream();
        if (product.getImage() != null) {
            out.write(product.getImage());
        } else {
            out.write(null);
        }
        out.close();
    }
}
