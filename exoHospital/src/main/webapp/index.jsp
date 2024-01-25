<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add patient</title>
    <jsp:include page="/includes/head.jsp"/>

</head>
<body>
<jsp:include page="/includes/header.jsp"/>

<div class="container mt-4">

    <h1 class="mb-3">La liste des patients</h1>

    <table class="table table-striped text-center" data-bs-theme="light">
        <thead>
        <tr>
            <th scope="col">Image</th>
            <th scope="col">Prénom</th>
            <th scope="col">Nom</th>
            <th scope="col">Date de naissance</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody class="table-group-divider text-info">

        <c:forEach items="${patients}" var="patient">
            <tr>
                <td><img src="${pageContext.request.contextPath}/imageServlet?id=${patient.getId()}" class="img-thumbnail" style="width: 50px;height: 50px;" alt="Image"></td>
                <td>${patient.getFirstName()}</td>
                <td>${patient.getLastName()}</td>
                <td>${patient.getBirthDate()} €</td>
                <td>
                    <a href="details?id=${patient.getId()}" role="button" class="btn btn-warning me-2"><i class="bi bi-eye me-2"></i>Détails</a>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>

    <c:if test="${empty patients}">
        <p class="text-center mt-3">Aucun patient n'est disponible pour le moment.</p>
    </c:if>

    <c:if test="${isLogged}">
        <div class="d-flex justify-content-end mt-3 mb-3">
            <a href="new" class="btn btn-success" role="button"><i class="bi bi-plus-circle me-2"></i>Ajouter un patient</a>
        </div>
    </c:if>
</div>

</body>
</html>