<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Détail du patient</title>
    <jsp:include page="/includes/head.jsp"/>
</head>

<body class="bg-light text-dark">
<jsp:include page="/includes/header.jsp"/>
<div class="container mt-5">

    <h1 class="mb-4">Détail du patient</h1>

    <div class="d-flex justify-content-end mb-3">
        <a class="btn btn-outline-primary" href="list" role="button">
            <i class="bi bi-arrow-bar-left me-2"></i>Précédent</a>
    </div>

    <c:choose>
        <c:when test="${not empty patient}">
            <div class="d-flex justify-content-center">
                <img src="${pageContext.request.contextPath}/imageServlet?id=${patient.getId()}" class="card-img-top img-thumbnail w-25 h-25 me-4" alt="Image du Produit">
            <div class="card text-white bg-info-subtle mb-3 border border-info">
                <div class="card-body">
                    <h5 class="card-title text-info">Nom:</h5>
                    <p class="card-text text-dark">${patient.lastName}</p>
                    <h5 class="text-info">Prénom:</h5>
                    <p class="card-text text-dark">${patient.firstName}</p>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item"><strong>Date de naissance:</strong> ${patient.birthDate}</li>
                </ul>
                <div class="d-flex justify-content-center mt-3 mb-3">
                    <c:if test="${isLogged}">
                        <a href="insert?id=${patient.getId()}" role="button" class="btn btn-success">Ajouter consultation</a>
                    </c:if>
                </div>
            </div>
            </div>
        </c:when>
        <c:otherwise>
            <p class="alert alert-warning">Le patient n'existe pas.</p>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
