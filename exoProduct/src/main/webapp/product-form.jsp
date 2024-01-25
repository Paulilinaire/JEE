<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Créer un product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body class="bg-dark">
<jsp:include page="WEB-INF/includes/header.jsp"/>
<div class="container mt-5">

    <h2 class="text-light mb-4">Formulaire de création d'un product</h2>

    <div class="d-flex justify-content-end mb-3">
        <a class="btn btn-outline-info" href="list" role="button">
            <i class="bi bi-arrow-bar-left me-2"></i>Précédent</a>
    </div>

    <div class="card border border-info-subtle" >
        <div class="card-body">
            <form action="${pageContext.request.contextPath}/${product == null ? 'insert' : 'update'}" method="post" enctype="multipart/form-data">
                <c:if test="${product != null}">
                    <input type="hidden" name="id" value="${product.getId()}">
                </c:if>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="reference">Reference: </label>
                        <input type="text" class="form-control" id="reference" name="reference" value="${product.getReference()}">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="brand">Marque: </label>
                        <input type="text" class="form-control" id="brand" name="brand" value="${product.getBrand()}">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="price">Prix: </label>
                        <input type="text" class="form-control" id="price" name="price" value="${product.getPrice()}">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="storage">Stock: </label>
                        <input type="text" class="form-control" id="storage" name="storage" value="${product.getStorage()}">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="saleDate">Date de vente: </label>
                        <input type="date" class="form-control" id="saleDate" name="saleDate" value="${product.getSaleDate()}">
                    </div>
                    <div>
                        <label for="image">Image: </label>
                        <input type="file" id="image" name="image" value="${product.getImage()}">
                    </div>
                </div>

                <div class="d-flex justify-content-end">
                    <button type="submit" class="btn btn-success"><span class="bi bi-plus-circle me-2"></span>${product == null ? 'Créer' : 'Mettre à jour'}</button>
                </div>

            </form>
        </div>
    </div>
</div>
</body>
</html>
