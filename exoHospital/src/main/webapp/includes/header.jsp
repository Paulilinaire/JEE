
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="head.jsp" />
  <title></title>
</head>
<body>

  <nav class="navbar navbar-expand-lg bg-light shadow-lg" data-bs-theme="light">
    <a class="navbar-brand" href="index.jsp"><i class="bi bi-prescription2"></i>MedApp</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item">
<%--          <c:if test="${isLogged}">--%>
            <a class="nav-link" href="patient-form.jsp">Ajouter un patient</a>
<%--          </c:if>--%>
        </li>
        <li class="nav-item text-end">
          <a class="nav-link" href="register.jsp">S'inscrire</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="login.jsp">Se connecter</a>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled">A propos</a>
        </li>
      </ul>
    </div>
  </nav>
</body>
</html>
