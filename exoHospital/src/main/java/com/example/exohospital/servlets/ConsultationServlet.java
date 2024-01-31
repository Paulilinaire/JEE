package com.example.exohospital.servlets;

import com.example.exohospital.entities.Consultation;
import com.example.exohospital.entities.Patient;
import com.example.exohospital.services.ConsultationService;
import com.example.exohospital.services.PatientService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@WebServlet("/consultation")
public class ConsultationServlet extends HttpServlet {

    private ConsultationService consultationService;
    private PatientService patientService;

    public void init() {
        consultationService = new ConsultationService();
        patientService = new PatientService();
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
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertConsultation(request, response);
                    break;
                case "/details":
                    showConsultation(request, response);
                    break;
                case "/list":
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
        request.getRequestDispatcher("patient-details.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("consultation-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertConsultation(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {

        try {
            LocalDate date = LocalDate.parse(req.getParameter("date"));
            String doctorName = req.getParameter("doctorName");
            long patientId = Long.parseLong(req.getParameter("patientId"));

            Patient patient = patientService.findById(patientId);

            Consultation consultation = new Consultation(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()), doctorName, patient);

            if (consultationService.create(consultation)) {
                resp.sendRedirect("/details?id=" + patient.getId());
            } else {
                resp.sendRedirect("consultation-form.jsp");
            }
        } catch (Exception e) {
            resp.sendRedirect("consultation-form.jsp");
        }
    }



    private void showConsultation(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        if (request.getParameter("id") != null) {
            long id = Long.parseLong(request.getParameter("id"));
            Consultation consultation = consultationService.findById(id);

            if (consultation != null) {
                request.setAttribute("consultation", consultation);
                RequestDispatcher dispatcher = request.getRequestDispatcher("patient-details.jsp");
                dispatcher.forward(request, response);
            } else {
                response.sendRedirect("consultation-form.jsp");
            }
        } else {
            response.sendRedirect("consultation-form.jsp");
        }
    }


    public void destroy() {
    }

}


