<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Login</title>
</head>
<body>
<div class="container">
    <h1 class="text-center">Login</h1>
    <form:form method="post" action="./login" modelAttribute="usuario">

        <div class="form-group row">
            <form:label path="email" class="col-sm-2 col-form-label">E-mail:</form:label>
            <div class="col-sm-10">
                <form:input path="email" class="form-control" type="text" required="required"/>
            </div>
        </div>
        <br>
        <div class="form-group row">
            <form:label path="senha" class="col-sm-2 col-form-label">Senha:</form:label>
            <div class="col-sm-10">
                <form:input path="senha" class="form-control" type="password" required="required"/>
            </div>
        </div>




<br>
    <input type="submit" class="btn btn-primary" value="Entrar">
</form:form>


    <c:if test="${erro}">
        <h2>
            <h6>E-mail ou senha incorretos</h6>
        </h2>
    </c:if>
</div>



</body>
</html>
