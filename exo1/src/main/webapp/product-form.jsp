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
        <a class="btn btn-outline-info" href="product-list.jsp" role="button">
            <i class="bi bi-arrow-bar-left me-2"></i>Précédent</a>
    </div>

    <card class="card border border-info-subtle" >
        <div class="card-body">
            <form action= "${product == null ? 'insert' : 'update'}" method="post" enctype="multipart/form-data">
                <c:if test="${product != null}">
                    <input type="hidden" name="id" value="${product.getId()}">
                </c:if>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputEmail4">Marque: </label>
                        <input type="text" class="form-control" id="inputEmail4" name="brand" value="${product != null ? product.getBrand() : ''}">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputPassword4">Reference: </label>
                        <input type="text" class="form-control" id="inputPassword4" name="reference" value="${product != null ? product.getReference() : ''}">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="inputAddress">Prix: </label>
                        <input type="text" class="form-control" id="inputAddress" placeholder="12" name="price" value="${product != null ? product.getPrice() : ''}">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="inputAddress2">Stock: </label>
                        <input type="text" class="form-control" id="inputAddress2" placeholder="50" name="stock" value="${product != null ? product.getStock() : ''}">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="inputAddress3">Date de vente: </label>
                        <input type="date" class="form-control" id="inputAddress3"  name="buyDate" value="${product != null ? product.getBuyDate() : ''}">
                    </div>
                </div>

                <div class="d-flex justify-content-end">
                    <button type="submit" class="btn btn-success"><span class="bi bi-plus-circle me-2"></span>Créer</button>
                </div>

            </form>
        </div>
    </card>
</div>
</body>
</html>
