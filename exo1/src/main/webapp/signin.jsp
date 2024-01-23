<%--
  Created by IntelliJ IDEA.
  User: Pauline
  Date: 23/01/2024
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Connecte-toi</h1>
<card>
    <form action="user" method="post">
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
