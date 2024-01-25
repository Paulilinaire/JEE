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

        <c:forEach items="${products}" var="product">
            <tr>
                <td><img src="${pageContext.request.contextPath}/imageServlet?id=${product.getId()}" class="img-thumbnail" style="width: 50px;height: 50px;" alt="Image"></td>
                <td>${product.getReference()}</td>
                <td>${product.getBrand()}</td>
                <td>${product.getPrice()} €</td>
                <td>${product.getSaleDate()}</td>
                <td>${product.getStorage()}</td>
                <td>
                    <a href="details?id=${product.getId()}" role="button" class="btn btn-warning me-2"><i class="bi bi-eye me-2"></i>Détails</a>
                    <a href="edit?id=${product.getId()}" role="button" class="btn btn-info me-2"><i class="bi bi-pencil-square me-2"></i>Editer</a>
                    <a href="delete?id=${product.getId()}" role="button" class="btn btn-danger"><i class="bi bi-trash me-2"></i>Supprimer</a>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>

    <c:if test="${empty products}">
        <p class="text-center text-light mt-3">Aucun produit n'est disponible pour le moment.</p>
    </c:if>

    <div class="d-flex justify-content-end mt-3 mb-3">
        <a href="new" class="btn btn-success" role="button"><i class="bi bi-plus-circle me-2"></i>Ajouter un produit</a>
    </div>
</div>

</body>
</html>
