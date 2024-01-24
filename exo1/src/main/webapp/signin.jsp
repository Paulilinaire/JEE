
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Se connecter</title>
</head>
<body>

<h1>Connecte-toi</h1>
<card>
    <form action="auth" method="post">
        <div class="mb-3">
            <label for="username" class="form-label">Pseudo : </label>
            <input type="text" class="form-control" id="username" name="username"></div>
        <div class="mb-3">
            <label for="password" class="form-label">Mot de passe :</label>
            <input type="password" class="form-control" id="password" name="password">
        </div>
        <button type="submit" class="btn btn-primary">Se connecter</button>
    </form>
</card>

</body>
</html>
