<%--
  Created by IntelliJ IDEA.
  User: Aluno
  Date: 22/07/2022
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Produtos</title>
</head>
<body>

<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
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

        <a class="navbar-brand" href="/fia/sair" >Sair</a>
    </div>
</nav>

<div class="container">

    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="/fia/produto/cadastrarProduto?e=${produto.id}">Produtos</a></li>
            <li class="breadcrumb-item active" aria-current="page">Editar produtos</li>
        </ol>
    </nav>

    <form:form method="post" action="/fia/produto/cadastrarProduto" modelAttribute="produto">

        <div class="form-group row">
            <form:label path="nome" class="col-sm-2 col-form-label">Nome do produto:</form:label>
            <div class="col-sm-10">
                <form:input path="nome" class="form-control" type="text" required="required"/>
            </div>
        </div>
        <br>
        <div class="form-group row">
            <form:label path="valor" class="col-sm-2 col-form-label">Valor:</form:label>
            <div class="col-sm-10">
                <form:input path="valor" class="form-control" type="number" step="0.1" required="required"/>
            </div>
        </div>





        <br>

        <button type="submit" class="btn btn-primary">Cadastrar</button>

    </form:form>


    <c:if test="${excluiu}">
        <h6>Produto excluído com sucesso</h6>
    </c:if>
        <br><br>



        <br><br>

        <h1>Produtos Disponíveis</h1>

        <table class="table table-striped">
            <thead class="table-dark">
            <tr>

                <th>Nome</th>
                <th>Valor</th>
                <th>Editar</th>
                <th>Excluir</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="p" items="${produtos}">
                <tr>

                    <td>${p.nome}</td>
                    <td>$${p.valor}</td>
                    <td><a href="/fia/produto/editarProduto?n=${p.id}">Editar</a></td>
                    <td><a href="/fia/produto/excluirProduto?n=${p.id}">Excluir</a></td>
                </tr>

            </c:forEach>
            </tbody>
        </table>
</div>

</body>

</html>
