<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulaire de création d'un produit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>
<body class="bg-dark">

<div class="container mt-5">
    <h2 class="text-light mb-4">Formulaire de création d'un produit</h2>

    <div class="d-flex justify-content-end mb-3">
        <a class="btn btn-outline-info" href="index.jsp" role="button">
            <i class="bi bi-arrow-bar-left me-2"></i>Précédent</a>
    </div>

    <div class="card border border-info-subtle" data-bs-theme="dark">
        <div class="card-body">
            <form action="product" method="post">

                <div class="mb-3">
                    <label for="reference" class="form-label">Nom :</label>
                    <input type="text" class="form-control" id="reference" name="reference" required>
                </div>

                <div class="mb-3">
                    <label for="brand" class="form-label">Marque :</label>
                    <input type="text" class="form-control" id="brand" name="brand" required>
                </div>

                <div class="mb-3">
                    <label for="price" class="form-label">Prix :</label>
                    <input type="number" class="form-control" id="price" name="price" step="0.01" required>
                </div>

                <div class="mb-3">
                    <label for="saleDate" class="form-label">Date de vente :</label>
                    <input type="date" class="form-control" id="saleDate" name="saleDate" required>
                </div>

                <div class="mb-3">
                    <label for="storage" class="form-label">Stock :</label>
                    <input type="number" class="form-control" id="storage" name="storage" required>
                </div>

                <div class="d-flex justify-content-end">
                    <button type="submit" class="btn btn-success"><span class="bi bi-plus-circle me-2"></span>Créer</button>
                </div>

            </form>
        </div>
    </div>
</div>

</body>
</html>
