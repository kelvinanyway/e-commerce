<%-- Document : cadastrarProduto Created on : 13/05/2024, 15:38:36 Author : Senai --%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
            <%@page contentType="text/html" pageEncoding="UTF-8" %>
                <!DOCTYPE html>
                <html>

                <head>
                    <link rel="stylesheet" href="./styles/cadastroProduto.css">
                    <link rel="shortcut icon" href="./assets/88header.png" type="image/x-icon">
                    <script src="https://kit.fontawesome.com/abf8e7610f.js" crossorigin="anonymous"></script>
                    <meta charset="UTF-8">
                    <title>Cadastro de Produto</title>
                    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
                </head>

                <body class="vh-100">
                    <header>
                        <div id="container-head">
                            <nav class="row g-0 justify-content-between align-items-center">
                                <div class="col-2 ">
                                    <a href="./home"><img class="img-header align-self-center"
                                            src="./assets/88header.png" alt="img header"></a>
                                </div>
                                <div class="col-1">
                                    <div class="row">
                                        <a class="col icon-link text-decoration-none text-dark d-flex justify-content-between "
                                            style="font-size: 2.5rem ;" href="./perfil">
                                            <i class="fa-solid fa-circle-user"></i>
                                        </a>
                                    </div>

                                </div>
                                <ul class="col-12 nav justify-content-center">
                                    <li class="nav-item">
                                        <a class="nav-link active text-dark " aria-current="page" href="./editarProduto">Editar
                                            Produtos</a>
                                    </li>
                                </ul>
                        </div>
                    </header>
                    <main class="m-2">
                        <div class="container">
                            <h2>Cadastro de Produtos</h2>
                            <form action="addProduto" method="post" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label for="nome">Nome:</label>
                                    <input type="text" class="form-control" id="nome" name="nome" required>
                                </div>
                                <div class="form-group">
                                    <label for="categoria">Categoria:</label>
                                    <select class="form-control" id="categoria" name="categoria">
                                        <c:if test="${fn:length(categorias) > 0}">
                                            <c:forEach var="categoria" items="${categorias}">
                                                <option value="${categoria.idCategoria}">${categoria.nome}</option>
                                            </c:forEach>
                                        </c:if>

                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="valor">Desconto:</label>
                                    <input type="number" step="0.01" class="form-control" id="desconto" name="desconto"
                                        required>
                                </div>
                                <div class="form-group">
                                    <label for="desconto">Valor:</label>
                                    <input type="number" step="0.01" class="form-control" id="valor" name="valor"
                                        required>
                                </div>
                                <div class="form-group">
                                    <label for="quantidade">Quantidade:</label>
                                    <textarea class="form-control" id="quantidade" name="quantidade" rows="1"></textarea>
                                </div>
                                <div class="form-group">
                                    <label for="validade">Validade:</label>
                                    <input type="date" class="form-control" id="validade" name="validade" required>
                                </div>
                                <div class="form-group">
                                    <label for="imagem">Imagem do Produto:</label>
                                    <input required type="file" class="form-control-file" id="imagem" name="imagem">
                                </div>
                                <button onclick="alert('produto adicionado com sucesso')"  type="submit" class="btn btn-primary">Cadastrar Produto</button>
                            </form>
                        </div>
                    </main>
                    <footer class="d-flex">
                        <p> Mercado88 &copy; todos os direitos reservados</p>
                    </footer>
                    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
                    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
                </body>

                </html>