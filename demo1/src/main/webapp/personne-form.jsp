<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Création de personne</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h2>Formulaire de création d'une personne</h2>
    <card>
    <form action="personne" method="post">
        <div class="mb-3">
            <label for="nom" class="form-label">Nom : </label>
            <input type="text" class="form-control" id="nom" name="nom"></div>
        <div class="mb-3">
            <label for="prenom" class="form-label">Prénom :</label>
            <input type="text" class="form-control" id="prenom" name="prenom">
        </div>
        <button type="submit" class="btn btn-primary">Créer</button>
    </form>
    </card>
</div>

</body>
</html>
