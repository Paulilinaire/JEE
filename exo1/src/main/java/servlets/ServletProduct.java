package servlets;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Product;


@WebServlet(name = "product", value = "/product")
public class ServletProduct extends HttpServlet {

    private ProductDAO productDAO;

    private List<Product> productList;


    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAO();
        productList = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action != null && action.equalsIgnoreCase("delete")) {
            long id = Long.parseLong(req.getParameter("id"));
            productDAO.deleteProduct(id);
            resp.sendRedirect("product");
        } else {
            productList = productDAO.getAllProducts();
            req.setAttribute("products", productList);
            req.getRequestDispatcher("product-list.jsp").forward(req, resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reference = req.getParameter("reference");
        String brand = req.getParameter("brand");
        double price = Double.parseDouble(req.getParameter("price"));
        LocalDate saleDate = LocalDate.parse(req.getParameter("saleDate"));
        int storage = Integer.parseInt(req.getParameter("storage"));

        Product newProduct = new Product(reference, brand, saleDate, price, storage);

        productDAO.addProduct(newProduct);

        productList = productDAO.getAllProducts();

        req.setAttribute("products", productList);

        req.getRequestDispatcher("product-list.jsp").forward(req, resp);
    }


    public void destroy() {
    }

}