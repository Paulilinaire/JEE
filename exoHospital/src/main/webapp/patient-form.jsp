<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter un patient</title>
    <jsp:include page="includes/head.jsp"/>
</head>
<body>
<jsp:include page="includes/header.jsp"/>
<div class="container mt-4">
    <h2 class="mb-4">Ajouter un patient</h2>
    <div class="card border border-info-subtle">
        <div class="card-body">
            <form action="insert" method="post" enctype="multipart/form-data">
                <div class="row mb-3">
                    <div class="col-md-6">
                        <label for="firstName" class="form-label">Prénom:</label>
                        <input type="text" class="form-control" id="firstName" name="firstName">
                    </div>
                    <div class="col-md-6">
                        <label for="lastName" class="form-label">Nom:</label>
                        <input type="text" class="form-control" id="lastName" name="lastName">
                    </div>
                </div>
                <div class="row mb-3">
                    <div class="col-md-4">
                        <label for="birthDate" class="form-label">Date de naissance:</label>
                        <input type="date" class="form-control" id="birthDate" name="birthDate">
                    </div>
                    <div class="col-md-4">
                        <label for="image" class="form-label">Photo:</label>
                        <input type="file" class="form-control" id="image" name="image">
                    </div>
                </div>

                <div class="d-flex justify-content-end">
                    <button type="submit" class="btn btn-primary"><i class="bi bi-plus-circle me-2"></i>Créer</button>
                </div>

            </form>
        </div>
    </div>
</div>
</body>
</html>
