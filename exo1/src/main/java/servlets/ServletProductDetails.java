package servlets;

import dao.ProductDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

import java.io.IOException;

@WebServlet(name = "product-details", value = "/product-details")
public class ServletProductDetails extends HttpServlet {

    private ProductDAOImpl productDAO;

    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAOImpl();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));

        Product product = productDAO.getProductById(id);

        req.setAttribute("product", product);
        req.getRequestDispatcher("product-details.jsp").forward(req, resp);
    }

    public void destroy() {
    }
}
