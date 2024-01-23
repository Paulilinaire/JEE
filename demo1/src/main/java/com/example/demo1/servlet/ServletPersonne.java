package com.example.demo1.servlet;

import com.example.demo1.model.Personne;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "personne", value = "/personne")
public class ServletPersonne extends HttpServlet {

    private List<Personne> personneList;

    @Override
    public void init() throws ServletException {
        personneList = new ArrayList<>();
        Personne personne = new Personne("Laout", "Amélie");
        Personne personne1 = new Personne("Thirion", "Daniel");

        personneList.add(personne);
        personneList.add(personne1);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        Personne personne = new Personne(nom, prenom);
        personneList.add(personne);
        req.setAttribute("personnes", personneList); // on donne un nom à personneList pour pouvoir l'utiliser dans personne_list.jsp (la Vue)
        req.getRequestDispatcher("personne-list.jsp").forward(req,resp); // renvoie ma requête, que je peux envoyer à une vue ou à une autre servlet


    }
}
