package com.example.exohospital.servlets;

import java.io.*;


import com.example.exohospital.entities.User;
import com.example.exohospital.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@WebServlet(name = "user", value = "/user")
public class UserServlet extends HttpServlet {

    private UserService userService;


    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username= req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        User newUser = new User(username, password, email);

        userService.create(newUser);

        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }


    public void destroy() {
    }

}