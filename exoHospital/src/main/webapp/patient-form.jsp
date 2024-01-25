<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add produit</title>
    <jsp:include page="includes/head.jsp"/>

</head>
<body>
<jsp:include page="includes/header.jsp"/>
<div class="container mt-4">

    <div class="card border border-info-subtle" >
        <div class="card-body">
            <form action="insert" method="post" enctype="multipart/form-data">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="firstName">Prénom: </label>
                        <input type="text" class="form-control" id="firstName" name="firstName">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="lastName">Nom: </label>
                        <input type="text" class="form-control" id="lastName" name="lastName">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="birthDate">Date de naissance: </label>
                        <input type="date" class="form-control" id="birthDate" name="birthDate">
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-4">
                            <label for="image">Photo: </label>
                            <input type="file" id="image" name="image">
                        </div>
                    </div>
                </div>

                <div class="d-flex justify-content-end">
                    <button type="submit" class="btn btn-success"><span class="bi bi-plus-circle me-2"></span>Créer</button>
                </div>

            </form>
        </div>
    </div>

</div>
</body>
</html>

