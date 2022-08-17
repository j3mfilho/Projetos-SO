<%--
  Created by IntelliJ IDEA.
  User: Aluno
  Date: 01/08/2022
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Editar Equipes</title>
</head>
<body>

<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/fia/produto/cadastrarProduto">Produtos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/fia/equipe/cadastrarEquipe">Equipes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/fia/encomenda/cadastrarEncomenda">Encomendas</a>
                </li>
            </ul>
        </div>

        <a class="navbar-brand" href="/fia/sair">Sair</a>
    </div>
</nav>

<div class="container">

    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="/fia/equipe/cadastrarEquipe?e=${equipe.id}">Equipes</a></li>
            <li class="breadcrumb-item active" aria-current="page">Cadastro equipes</li>
        </ol>
    </nav>

    <form:form action="/fia/equipe/editarEquipe" method="post" modelAttribute="equipe">
    <form:input path="id" type="hidden"/>

        <div class="form-group row">
            <form:label path="nome" class="col-sm-2 col-form-label">Nome da equipe:</form:label>
            <div class="col-sm-10">
                <form:input path="nome" class="form-control" type="text" required="required"/>
            </div>
        </div>

    <br>
    <div class="form-group row">
        <form:label path="endereco" class="col-sm-2 col-form-label">Endereço:</form:label>
        <div class="col-sm-10">
            <form:input path="endereco" class="form-control" type="text" required="required"/>
        </div>
    </div>
    <br>

        <button type="submit" class="btn btn-primary" value="Salvar">Salvar</button>
    </form:form>



    <c:if test="${not empty erro}">
    <h2>
        <b>${erro}</b>
    </h2>
    </c:if>
</body>
</html>
