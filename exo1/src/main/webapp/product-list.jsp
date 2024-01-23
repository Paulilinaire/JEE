<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Produits</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    <script>
        function confirmDelete(productId) {
            var isConfirmed = confirm("Etes vous sûr de vouloir supprimé ce produit?");
            if (isConfirmed) {
                window.location.href = 'product?id=' + productId + '&action=delete';
            }
        }
    </script>
</head>
<body>
<div class="container">

<h1>La liste des produits</h1>

<table class="table table-light table-striped mt-3">
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
    <tbody>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.getReference()}</td>
            <td>${product.getBrand()}</td>
            <td>${product.getPrice()} €</td>
            <td>${product.getSaleDate()}</td>
            <td>${product.getStorage()}</td>
            <td>
                <!-- Details link with the product id as a parameter -->
                <a href="product-details?id=${product.getId()}">Details</a>
            </td>
            <td>
                <!-- Delete link with the product id as a parameter -->
                <a href="confirmDelete?id=(${product.getId()})">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<c:if test="${empty products}">
    <p>Aucun produit n'est disponible pour le moment.</p>
</c:if>

</div>
</body>
</html>
