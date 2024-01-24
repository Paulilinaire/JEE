<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inscription</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body class="bg-dark">
<div class="container">

    <h2 class="text-light mt-3 mb-3">Inscription</h2>

    <card class="card border border-info-subtle" data-bs-theme="dark" >
        <div class="card-body">
        <form action="user" method="post">
            <div class="mb-3">
                <label for="username" class="form-label">Pseudo : </label>
                <input type="text" class="form-control" id="username" name="username"></div>
            <div class="mb-3">
                <label for="password" class="form-label">Mot de passe :</label>
                <input type="password" class="form-control" id="password" name="password">
            </div>
            <button type="submit" class="btn btn-primary">S'inscrire</button>
        </form>
        </div>
    </card>
</div>

</body>
</html>

