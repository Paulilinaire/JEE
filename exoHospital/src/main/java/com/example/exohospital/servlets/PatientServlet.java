package com.example.exohospital.servlets;

import com.example.exohospital.entities.Consultation;
import com.example.exohospital.entities.Patient;
import com.example.exohospital.services.PatientService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@WebServlet("/")
@MultipartConfig(maxFileSize = 1024*1024*10)
public class PatientServlet extends HttpServlet {

    private PatientService patientService;

    public void init() {
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
                    insertPatient(request, response);
                    break;
                case "/details":
                    showPatient(request, response);
                    break;
                case "/list":
                    listPatient(request, response);
                    break;
                default:
                    listPatient(request, response);
                    break;
            }
        } catch (
                SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listPatient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        request.setAttribute("patients", patientService.findAll());
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("patient-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertPatient(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {

        Part imagePart = req.getPart("image");

        String fileType = imagePart.getContentType();

        if(fileType.equalsIgnoreCase("image/jpeg")){ // verifie si l'image est bien png

            byte[] imagesBytes = null;
            if(imagePart != null){
                InputStream inputStream = imagePart.getInputStream();// converti mon part en un flux (1 byte = 1 octet)
                imagesBytes = inputStream.readAllBytes();
            }
            String lastName = req.getParameter("lastName");
            System.out.println("lastName "+ lastName );
            String firstName = req.getParameter("firstName");
            System.out.println("firstName "+ firstName );
            LocalDate birthDate = LocalDate.parse(req.getParameter("birthDate"));
            System.out.println("date "+ birthDate );

            Patient patient = new Patient(lastName, firstName, Date.from(birthDate.atStartOfDay(ZoneId.systemDefault()).toInstant()), imagesBytes);

            if (patientService.create(patient)) {
                resp.sendRedirect("list");
            }else{
                resp.sendRedirect("patient-form.jsp");
            }
        }
    }


    private void showPatient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        if (request.getParameter("id") != null) {
            long id = Long.parseLong(request.getParameter("id"));
            Patient patient = patientService.findById(id);

            if (patient != null) {
                request.setAttribute("patient", patient);
                RequestDispatcher dispatcher = request.getRequestDispatcher("patient-details.jsp");
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
