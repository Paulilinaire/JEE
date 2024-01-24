<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Détail du produit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>

<body class="bg-dark text-light">

<div class="container mt-5">
    <h1 class="mb-4">Détail du produit</h1>

    <div class="d-flex justify-content-end mb-3">
        <a class="btn btn-outline-info" href="product-list.jsp" role="button">
            <i class="bi bi-arrow-bar-left me-2"></i>Précédent</a>
    </div>

    <c:choose>
        <c:when test="${not empty product}">
            <div class="card text-white bg-secondary mb-3 border border-info">
                <div class="card-body">
                    <h5 class="card-title">Référence</h5>
                    <p class="card-text">${product.reference}</p>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item"><strong>Marque:</strong> ${product.brand}</li>
                    <li class="list-group-item"><strong>Prix:</strong> ${product.price} €</li>
                    <li class="list-group-item"><strong>Date de vente:</strong> ${product.saleDate}</li>
                    <li class="list-group-item"><strong>Stock:</strong> ${product.storage}</li>
                </ul>
            </div>
        </c:when>
        <c:otherwise>
            <p class="alert alert-warning">Le produit n'existe pas.</p>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
