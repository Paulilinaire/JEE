package com.example.demo1.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

@WebServlet(name = "upload", value = "/upload")
@MultipartConfig(maxFileSize = 1024*1024*10)
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uploadPath = getServletContext().getRealPath("/") + "images";

        File file = new File(uploadPath); // file peut soit être un fichier soit un dossier

        if(!file.exists()){
            file.mkdir(); // make directory // on créer le dossier où il y aura l'image
        }

        Part image = req.getPart("image"); // entre paranthèse on met le nom de l'image qu'on a mis dans le form // on enregistre le nom de l'image

        String fileName = image.getSubmittedFileName();

        image.write(uploadPath + File.separator + fileName);

    }
}
