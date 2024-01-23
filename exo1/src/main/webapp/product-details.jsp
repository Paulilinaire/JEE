<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Détail du produit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>

<div class="container">

    <c:if test="${not empty product}">
        <div>
        <p>Référence: ${product.reference}</p>
        <p>Marque: ${product.brand}</p>
        <p>Prix: ${product.price} €</p>
        <p>Date de vente: ${product.saleDate}</p>
        <p>Stock: ${product.storage}</p>
        </div>
    </c:if>

<c:if test="${empty product}">
    <p>Le produit n'existe pas.</p>
</c:if>
</div>
</body>
</html>
