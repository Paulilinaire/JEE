<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Consultation</title>
    <jsp:include page="includes/head.jsp"/>
</head>
<body>
<jsp:include page="includes/header.jsp"/>
<div class="container mt-4">
    <h2 class="mb-4">Ajouter une consultation</h2>
    <div class="card border border-info-subtle">
        <div class="card-body">
            <form action="consultation/insert" method="post" enctype="multipart/form-data">
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="date" class="form-label">Date:</label>
                        <input type="date" class="form-control" id="date" name="date" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="doctorName" class="form-label">Nom du docteur:</label>
                        <input type="text" class="form-control" id="doctorName" name="doctorName" required>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="prescription" class="form-label">Prescription:</label>
                        <a href="prescription-form.jsp" class="btn btn-outline-success" id="prescription">Ajouter prescription</a>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="careSheet" class="form-label">Fiche de soin:</label>
                        <a href="careSheet-form.jsp" class="btn btn-outline-success" id="careSheet">Ajouter fiche de soin</a>
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
