<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

</head>
<body>
<h1><%= "Product App" %>
</h1>
<br/>
<div class="mb-3">
    <a href="product">Afficher la totalité des produits</a>
</div>
<div class="mb-3">
    <a href="product-form.jsp">Ajouter un produit</a>
</div>
</body>
</html>