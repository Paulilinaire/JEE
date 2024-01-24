<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UpLoad</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<form action="upload" method="post" enctype="multipart/form-data">
    <div>
        <input type="file" name="image"/>
    </div>
    <div>
        <button type="submit" class="btn btn-primary">Charger</button>
    </div>
</form>
</body>
</html>