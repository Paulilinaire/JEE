package com.example.exohospital.servlets;

import com.example.exohospital.entities.CareSheet;
import com.example.exohospital.services.CareSheetService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/careSheet/careSheet")
public class CareSheetServlet extends HttpServlet {

    private CareSheetService careSheetService;

    public void init() {
        careSheetService = new CareSheetService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/caresheet/new":
                    showNewForm(request, response);
                    break;
                case "/caresheet/insert":
                    insertCareSheet(request, response);
                    break;
                case "/caresheet/details":
                    showCareSheet(request, response);
                    break;
                case "/caresheet/list":
                    listCareSheet(request, response);
                    break;
                default:
                    listCareSheet(request, response);
                    break;
            }
        } catch (
                SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listCareSheet(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        request.setAttribute("careSheets", careSheetService.findAll());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("careSheet-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertCareSheet(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {

        String careSheetType = req.getParameter("careSheetType");
        System.out.println("careSheetType " + careSheetType);
        String duration = req.getParameter("duration");
        System.out.println("duration " + duration);

        CareSheet careSheet = new CareSheet(careSheetType, duration);

        if (careSheetService.create(careSheet)) {
            resp.sendRedirect("list");
        } else {
            resp.sendRedirect("careSheet-form.jsp");
        }
    }


    private void showCareSheet(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        if (request.getParameter("id") != null) {
            long id = Long.parseLong(request.getParameter("id"));
            CareSheet careSheet = careSheetService.findById(id);

            if (careSheet != null) {
                request.setAttribute("careSheet", careSheet);
                RequestDispatcher dispatcher = request.getRequestDispatcher("careSheet-details.jsp");
                dispatcher.forward(request, response);
            } else {
                response.sendRedirect("list");
            }
        } else {
            response.sendRedirect("list");
        }
    }


    public void destroy() {
    }

}

