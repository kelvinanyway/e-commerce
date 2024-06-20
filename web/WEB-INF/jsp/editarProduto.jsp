<%-- Document : editarProduto Created on : 14/06/2024, 14:52:46 Author : Senai --%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <%@page contentType="text/html" pageEncoding="UTF-8" %>
                <!DOCTYPE html>
                <html>

                <head>
                    <link rel="stylesheet" href="./styles/editarProduto.css">
                    <link rel="stylesheet" href="./styles/slider.css">
                    <link rel="shortcut icon" href="./assets/88header.png" type="image/x-icon">
                    <script src="https://kit.fontawesome.com/abf8e7610f.js" crossorigin="anonymous"></script>
                    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
                    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                    <title>Editar Produto</title>
                </head>
                <fmt:setLocale value="pt_BR" />

                <body>
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
                                        <a class="nav-link active text-dark " aria-current="page"
                                            href="./cadastro-de-produto">Cadastrar Produto</a>
                                    </li>
                                </ul>
                        </div>
                    </header>
                        <main>
                            <div class="produto row m-5">
                                <c:forEach items="${produtos}" var="produto">
                                    <div class="produto-card">
                                        <div class="produto-imagem">
                                            <form action="excluirProduto" method="post">
                                                <button class="excluirProduto" name="excluir"
                                                    value="${produto.idProduto}" type="submit"><i
                                                        class="fa-solid fa-trash"></i></button>
                                            </form>
                                            <span class="tag-desconto">
                                                <form action="atualizarDesconto" method="post">
                                                    <input step="0.01" name="desconto" id="inputDesconto" type="number"
                                                        placeholder="Desc: ${produto.desconto}" />
                                                    <button value="${produto.idProduto}" class="btnAtualizar" type="submit"
                                                        name="atualizarDesconto"><i
                                                            class="fa-solid fa-pen"></i></button>
                                                </form>
                                            </span>
                                            <img src="data:image/png;base64,${produto.imagemBase64}"
                                                class="produto-capa" alt="">
                                        </div>
                                        <div class="pl-4">
                                            <form action="atualizarNomeProduto" method="post">
                                                <input name="nome" id="inputNome" type="text"
                                                    placeholder="Nome: ${produto.nome}" />
                                                <button class="btnAtualizar" type="submit" value="${produto.idProduto}"
                                                    name="atualizarNomeProduto"><i class="fa-solid fa-pen"></i></button>
                                            </form>
                                            <div>

                                            </div>
                                            <div id="div-valor">
                                                <span class="valor">
                                                    <form action="atualizarValor" method="post">
                                                        <input step="0.01" name="valor" id="inputValor" type="number"
                                                            placeholder="Valor: ${produto.valor}" />
                                                        <button class="btnAtualizar" type="submit"
                                                            name="atualizarValor" value="${produto.idProduto}"><i
                                                                class="fa-solid fa-pen"></i></button>
                                                    </form>
                                                </span>
                                            </div>
                                            <div id="quantidade">
                                                <form action="atualizarQuantidade" method="post">
                                                    <input name="quantidade" id="inputQuantidade" type="number"
                                                        placeholder="Quantidade: ${produto.quantidade}" />
                                                    <button class="btnAtualizar" type="submit" value="${produto.idProduto}" name="atualizarQuantidade"><i
                                                            class="fa-solid fa-pen"></i></button>
                                                </form>
                                            </div>
                                            </form>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </main>
                    <footer class="d-flex">
                        <p> Mercado88 &copy; todos os direitos reservados</p>
                    </footer>
                </body>

                </html>