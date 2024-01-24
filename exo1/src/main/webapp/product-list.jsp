<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>La liste des produits</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body class="bg-dark">

<div class="container mt-5">
    <h1 class="text-light mb-3">La liste des produits</h1>

<div class="d-flex justify-content-end mb-3">
    <a class="btn btn-outline-info" href="index.jsp" role="button">
        <i class="bi bi-arrow-bar-left me-2"></i>Précédent</a>
</div>

    <table class="table table-striped text-center" data-bs-theme="dark">
        <thead>
        <tr>
            <th scope="col">Nom</th>
            <th scope="col">Marque</th>
            <th scope="col">Prix</th>
            <th scope="col">Date de vente</th>
            <th scope="col">Stock</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody class="table-group-divider text-info">
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.getReference()}</td>
                <td>${product.getBrand()}</td>
                <td>${product.getPrice()} €</td>
                <td>${product.getSaleDate()}</td>
                <td>${product.getStorage()}</td>
                <td>
                    <!-- Details button with the product id as a parameter -->
                    <a class="btn btn-warning me-2" href="product-details?id=${product.getId()}" role="button">
                        <i class="bi bi-eye"></i> Details
                    </a>
                    <!-- Delete button with the product id as a parameter -->
                    <a class="btn btn-danger" href="product?action=delete&id=${product.getId()}" role="button">
                        <i class="bi bi-trash"></i> Supprimer
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <c:if test="${empty products}">
        <p class="text-center mt-3">Aucun produit n'est disponible pour le moment.</p>
    </c:if>



</div>

</body>
</html>
