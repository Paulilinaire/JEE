package servlets;

import java.io.*;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.LocalDate;


import dao.ProductDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Product;


@WebServlet("/")
public class ServletProduct extends HttpServlet {

    private ProductDAO productDAO;

    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        boolean logged = session.getAttribute("isLogged") != null && (boolean) session.getAttribute("isLogged");

        if(logged){

        String action = request.getServletPath();

            try {
                switch (action) {
                    case "/new":
                        showNewForm(request, response);
                        break;
                    case "/insert":
                        insertProduct(request, response);
                        break;
                    case "/delete":
                        deleteProduct(request, response);
                        break;
                    case "/edit":
                        showEditForm(request, response);
                        break;
                    case "/details":
                        showProduct(request, response);
                        break;
                    case "/update":
                        updateProduct(request, response);
                        break;
                    case "/list":
                        listProduct(request, response);
                        break;
                    default:
                        listProduct(request, response);
                        break;
                }
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }
        }else{
            response.sendRedirect("signin.jsp");
        }

    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        request.setAttribute("products", productDAO.findAll());
        request.getRequestDispatcher("product-list.jsp").forward(request,response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertProduct(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {

        String reference = req.getParameter("reference");
        String brand = req.getParameter("brand");
        double price = Double.parseDouble(req.getParameter("price"));
        LocalDate saleDate = LocalDate.parse(req.getParameter("saleDate"));
        int storage = Integer.parseInt(req.getParameter("storage"));
        Product product = new Product(reference, brand, saleDate, price, storage);

        if (productDAO.create(product)) {
            resp.sendRedirect("list");
        }else{
            resp.sendRedirect("product-form.jsp");
        }
    }


    private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.findById(id);
        if(product != null){
            productDAO.delete(product);
        }
        response.sendRedirect("list");
    }

    private void showProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        if (request.getParameter("id") != null) {
            long id = Long.parseLong(request.getParameter("id"));
            Product product = productDAO.findById(id);

            if (product != null) {
                request.setAttribute("product", product);
                RequestDispatcher dispatcher = request.getRequestDispatcher("product-details.jsp");
                dispatcher.forward(request, response);
            } else {
                response.sendRedirect("list");
            }
        } else {
            response.sendRedirect("list");
        }
    }


    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));

        Product existingProduct = productDAO.findById(id);

        RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");
        request.setAttribute("product", existingProduct);
        dispatcher.forward(request, response);
    }


    private void updateProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        long id = Long.parseLong(request.getParameter("id"));
        Product productToUpdate = productDAO.findById(id);

        if (productToUpdate != null) {
            // Update the existing product
            productToUpdate.setReference(request.getParameter("reference"));
            productToUpdate.setBrand(request.getParameter("brand"));
            productToUpdate.setSaleDate(LocalDate.parse(request.getParameter("saleDate")));
            productToUpdate.setPrice(Double.parseDouble(request.getParameter("price")));
            productToUpdate.setStorage(Integer.parseInt(request.getParameter("storage")));

            // Call the image handling method
            handleImageUpload(request, "image", productToUpdate);

            if (productDAO.update(productToUpdate)) {
                    response.sendRedirect("list");
                }else{
                    response.sendRedirect("product-form.jsp");
                }
        }
    }


    private void handleImageUpload(HttpServletRequest req, String formFieldName, Product product) throws IOException, ServletException {
        String uploadPath = getServletContext().getRealPath("/") + "images";
        File uploadDirectory = new File(uploadPath);

        if (!uploadDirectory.exists()) {
            uploadDirectory.mkdir();
        }

        Part imagePart = req.getPart(formFieldName);
        String fileName = Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();
        String imagePath = uploadPath + File.separator + fileName;

        imagePart.write(imagePath);

        // Set the image path in your product object or store it in the database.
        product.setImagePath(imagePath);
    }


    public void destroy() {
    }

}