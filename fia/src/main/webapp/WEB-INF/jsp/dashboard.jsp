<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Página Inicial</title>
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



</body>

</html>

