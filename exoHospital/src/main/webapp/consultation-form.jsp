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
    <div class="card border border-info-subtle">
        <div class="card-body">
            <form action="consultation/insert" method="post" enctype="multipart/form-data">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="date">Date:</label>
                        <input type="date" class="form-control" id="date" name="date" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="doctorName">Doctor Name:</label>
                        <input type="text" class="form-control" id="doctorName" name="doctorName" required>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <p>Prescription: </p>
                        <a href="prescription/insert?consultationId=${consultation.getId()}" role="button" class="btn btn-success">Ajouter prescription</a>
                    </div>
                    <div class="form-group col-md-6">
                        <p>Fiche de soin: </p>
                        <a href="caresheet/insert?consultationId=${consultation.getId()}" role="button" class="btn btn-success">Ajouter fiche de soin</a>
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
