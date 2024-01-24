package servlets;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utils.Definition;

import java.io.IOException;

@WebServlet(name = "signin", value = "/signin")
public class ServletAuth extends HttpServlet {

    UserDAO userDAO = new UserDAO();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Use the UserDAO to authenticate the user
        boolean isAuthenticated = userDAO.getUserByAuth(username, password);

        if (isAuthenticated) {
            // Set session attributes to indicate the user is logged in
            HttpSession session = req.getSession();
            session.setAttribute("isLogged", true);
            session.setAttribute("username", username);

            // Log for debugging
            System.out.println("User successfully authenticated. Redirecting to index.jsp.");

            // Redirect to the home page or any other secured page
            resp.sendRedirect("index.jsp");
        } else {
            // If authentication fails, show an error message
            req.setAttribute("message", "Authentication failed. Please check your username and password.");
            req.getRequestDispatcher("auth-failed.jsp").forward(req, resp);
        }
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
