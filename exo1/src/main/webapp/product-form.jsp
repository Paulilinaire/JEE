<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <h2>Formulaire de création d'un produit</h2>
    <card>
        <form action="product" method="post">
            <div class="mb-3">
                <label for="reference" class="form-label">Nom : </label>
                <input type="text" class="form-control" id="reference" name="reference"></div>
            <div class="mb-3">
                <label for="brand" class="form-label">Marque :</label>
                <input type="text" class="form-control" id="brand" name="brand">
            </div>
            <div class="mb-3">
                <label for="price" class="form-label">Prix :</label>
                <input type="text" class="form-control" id="price" name="price">
            </div>
            <div class="mb-3">
                <label for="saleDate" class="form-label">Marque :</label>
                <input type="date" class="form-control" id="saleDate" name="saleDate">
            </div>
            <div class="mb-3">
                <label for="storage" class="form-label">Stock :</label>
                <input type="text" class="form-control" id="storage" name="storage">
            </div>
            <button type="submit" class="btn btn-primary">Créer</button>
        </form>
    </card>
</div>

</body>
</html>
