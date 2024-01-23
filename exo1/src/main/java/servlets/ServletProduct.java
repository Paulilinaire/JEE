package servlets;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Product;


@WebServlet(name = "product", value = {"/product", "/confirmDelete"})
public class ServletProduct extends HttpServlet {

    private ProductDAOImpl productDAO;

    private List<Product> productList;
    private Product product;


    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAOImpl();
        productList = new ArrayList<>();
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        productList = productDAO.getAllProducts();
        req.setAttribute("products", productList);
        req.getRequestDispatcher("product-list.jsp").forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieve form parameters
        String reference = req.getParameter("reference");
        String brand = req.getParameter("brand");
        double price = Double.parseDouble(req.getParameter("price"));
        LocalDate saleDate = LocalDate.parse(req.getParameter("saleDate"));
        int storage = Integer.parseInt(req.getParameter("storage"));

        Product newProduct = new Product(reference, brand, saleDate, price, storage);

        productDAO.addProduct(newProduct);

        // Update the product list after adding
        productList = productDAO.getAllProducts();

        req.setAttribute("products", productList);

        req.getRequestDispatcher("product-list.jsp").forward(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));

        productDAO.deleteProduct(id);

        // Update the product list after deletion
        productList = productDAO.getAllProducts();

        // Forward to the product-list.jsp with the updated list
        req.setAttribute("products", productList);
        req.getRequestDispatcher("product-list.jsp").forward(req, resp);


    }

    public void destroy() {
    }
}