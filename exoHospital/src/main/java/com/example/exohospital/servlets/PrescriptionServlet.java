package com.example.exohospital.servlets;

import com.example.exohospital.entities.Prescription;
import com.example.exohospital.services.PrescriptionService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/prescription")
public class PrescriptionServlet extends HttpServlet {

    private PrescriptionService prescriptionService;

    public void init() {
        prescriptionService = new PrescriptionService();
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
                case "/prescription/new":
                    showNewForm(request, response);
                    break;
                case "/prescription/insert":
                    insertPrescription(request, response);
                    break;
                case "/prescription/details":
                    showPrescription(request, response);
                    break;
                case "/prescription/list":
                    listPrescription(request, response);
                    break;
                default:
                    listPrescription(request, response);
                    break;
            }
        } catch (
                SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listPrescription(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        request.setAttribute("prescriptions", prescriptionService.findAll());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("prescription-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertPrescription(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {

        String medicine = req.getParameter("medicine");
        System.out.println("medicine " + medicine);
        String duration = req.getParameter("duration");
        System.out.println("duration " + duration);

        Prescription prescription = new Prescription(medicine, duration);

        if (prescriptionService.create(prescription)) {
            resp.sendRedirect("list");
        } else {
            resp.sendRedirect("prescription-form.jsp");
        }
    }


    private void showPrescription(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        if (request.getParameter("id") != null) {
            long id = Long.parseLong(request.getParameter("id"));
            Prescription prescription = prescriptionService.findById(id);

            if (prescription != null) {
                request.setAttribute("prescription", prescription);
                RequestDispatcher dispatcher = request.getRequestDispatcher("prescription-details.jsp");
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

