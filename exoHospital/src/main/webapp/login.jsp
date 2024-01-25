
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    <title>Se connecter</title>
</head>

<body class="bg-light">
<div class="container">

<h2 class="text-info-subtle mt-3 mb-3">Se connecter</h2>


<div class="card border border-info-subtle w-50">
    <div class="card-body">
    <form action="login" method="post">
        <div class="mb-3">
            <label for="username" class="form-label">Pseudo : </label>
            <input type="text" class="form-control" id="username" name="username"></div>
        <div class="mb-3">
            <label for="password" class="form-label">Mot de passe :</label>
            <input type="password" class="form-control" id="password" name="password">
        </div>
        <div class="d-flex justify-content-end">
            <button type="submit" class="btn btn-primary">Se connecter</button>
        </div>
    </form>
    </div>
</div>
</div>
</body>
</html>
