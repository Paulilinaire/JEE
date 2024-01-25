<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>Register</title>
</head>
<body>
<div class="container d-flex flex-column justify-content-center h-100 w-50">
    <h2 class="mb-3">S'enregistrer</h2>
    <form action="user" method="post">
        <div class="mb-3">
            <label for="name" class="form-label">Identifiant</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Adresse email</label>
            <input type="email" class="form-control" id="email" name="email">
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Mot de passe</label>
            <input type="password" class="form-control" id="password" name="password">
        </div>

        <div class="d-flex justify-content-end">
            <button type="submit" class="btn btn-primary">S'enregistrer</button>
        </div>
        <div class="d-flex justify-content-end">
            <p><a href="login.jsp">Déjà inscrit</a></p>
        </div>

    </form>
</div>
</body>
</html>
