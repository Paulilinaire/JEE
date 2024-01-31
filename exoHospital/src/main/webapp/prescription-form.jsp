<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter une prescription</title>
    <jsp:include page="includes/head.jsp"/>
</head>
<body>
<jsp:include page="includes/header.jsp"/>
<div class="container mt-4">
    <h2 class="mb-4">Ajouter une prescription</h2>
    <div class="card border border-info-subtle">
        <div class="card-body">
            <form action="prescription/insert" method="post" enctype="multipart/form-data">
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="medicine" class="form-label">Médicaments:</label>
                        <input type="text" class="form-control" id="medicine" name="medicine" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="duration" class="form-label">Durée :</label>
                        <input type="text" class="form-control" id="duration" name="duration" required>
                    </div>
                </div>
                <div class="d-flex justify-content-end">
                    <button type="submit" class="btn btn-primary"><i class="bi bi-plus-circle me-2"></i>Ajouter</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
