package com.example.exohospital.servlets;

import com.example.exohospital.entities.Consultation;
import com.example.exohospital.services.ConsultationService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/consultation")
public class ConsultationServlet extends HttpServlet {

    private ConsultationService consultationService;

    public void init() {
        consultationService = new ConsultationService();
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
                case "/consultation/new":
                    showNewForm(request, response);
                    break;
                case "/consultation/insert":
//                    insertConsultation(request, response);
                    break;
                case "/consultation/details":
                    showConsultation(request, response);
                    break;
                case "/consultation/list":
                    listConsultation(request, response);
                    break;
                default:
                    listConsultation(request, response);
                    break;
            }
        } catch (
                SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listConsultation(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        request.setAttribute("consultations", consultationService.findAll());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("consultation-form.jsp");
        dispatcher.forward(request, response);
    }

//    private void insertConsultation(HttpServletRequest req, HttpServletResponse resp)
//            throws SQLException, IOException, ServletException {
//
//        String medicine = req.getParameter("medicine");
//        System.out.println("medicine " + medicine);
//        String duration = req.getParameter("duration");
//        System.out.println("duration " + duration);
//
//        Consultation consultation = new Consultation(date, doctorName, patientId);
//
//        if (consultationService.create(consultation)) {
//            resp.sendRedirect("list");
//        } else {
//            resp.sendRedirect("consultation-form.jsp");
//        }
//    }


    private void showConsultation(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        if (request.getParameter("id") != null) {
            long id = Long.parseLong(request.getParameter("id"));
            Consultation consultation = consultationService.findById(id);

            if (consultation != null) {
                request.setAttribute("consultation", consultation);
                RequestDispatcher dispatcher = request.getRequestDispatcher("consultation-details.jsp");
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


