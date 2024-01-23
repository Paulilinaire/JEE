<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Personne</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

</head>
<body>

<h1>La liste des personnes</h1>

<c:forEach items="${personnes}" var="personne">
    <div class="mb-3">
        Nom: ${personne.getNom()}
        Prenom: ${personne.getPrenom()}
    </div>
</c:forEach>


</body>
</html>
