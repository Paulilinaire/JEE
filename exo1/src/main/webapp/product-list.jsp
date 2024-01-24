<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>La liste des produits</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body class="bg-dark">
<jsp:include page="WEB-INF/includes/header.jsp"/>

<div class="container mt-5">
    <h1 class="text-light mb-3">La liste des produits</h1>

    <table class="table table-striped text-center" data-bs-theme="dark">
        <!-- Table Header -->
        <thead>
        <tr>
            <th scope="col">Image</th>
            <th scope="col">Nom</th>
            <th scope="col">Marque</th>
            <th scope="col">Prix</th>
            <th scope="col">Date de vente</th>
            <th scope="col">Stock</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody class="table-group-divider text-info">
        <!-- Iterate through products -->
        <c:forEach items="${products}" var="product">
            <tr>
                <!-- Display product information -->
                <td></td>
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
                    <!-- Update button with the product id as a parameter -->
                    <button type="button" class="btn btn-info me-2" data-target="updateModal${product.getId()}" data-bs-toggle="modal" data-bs-target="#updateModal${product.getId()}">
                        <i class="bi bi-pencil-square"></i> Edit
                    </button>
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
        <p class="text-center text-light mt-3">Aucun produit n'est disponible pour le moment.</p>
    </c:if>

    <div class="d-flex justify-content-end mt-3 mb-3">
        <a href="product-form.jsp" class="btn btn-success" role="button"><i class="bi bi-plus-circle me-2"></i>Ajouter un produit</a>
    </div>
</div>

</body>
</html>
