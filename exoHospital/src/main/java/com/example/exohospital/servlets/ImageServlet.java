package com.example.exohospital.servlets;

import com.example.exohospital.entities.Patient;
import com.example.exohospital.services.PatientService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/imageServlet")
public class ImageServlet extends HttpServlet {

    private PatientService patientService;

    public void init() {

        patientService = new PatientService();

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Patient patient = patientService.findById(id);
        response.setContentType("image/png");
        OutputStream out = response.getOutputStream();
        if (patient.getImage() != null) {
            out.write(patient.getImage());
        } else {
            out.write(null);
        }
        out.close();
    }
}
