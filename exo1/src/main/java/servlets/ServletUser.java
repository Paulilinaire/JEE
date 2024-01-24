package servlets;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.User;
import utils.Definition;


@WebServlet(name = "user", value = "/user")
public class ServletUser extends HttpServlet {

    private UserDAO userDAO;

    private List<User> userList;


    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
        userList = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action != null && action.equalsIgnoreCase("delete")) {
            long id = Long.parseLong(req.getParameter("id"));
            userDAO.deleteUser(id);
            resp.sendRedirect(Definition.VIEW_PATH+"user");
        } else {
            userList = userDAO.getAllUsers();
            req.setAttribute("users", userList);
            req.getRequestDispatcher("user-list.jsp").forward(req, resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username= req.getParameter("username");
        String password = req.getParameter("password");

        User newUser = new User(username, password);

        userDAO.addUser(newUser);

        userList = userDAO.getAllUsers();

        req.setAttribute("users", userList);

        req.getRequestDispatcher("signin.jsp").forward(req, resp);
    }


    public void destroy() {
    }

}