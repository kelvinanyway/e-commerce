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
                        <div class="container">

                        </div>
                    </header>
                    <main>
                        <div class="produto d-flex flex-row">
                            <c:forEach items="${produtos}" var="produto">
                                <div class="produto-card">
                                    <div class="produto-imagem">
                                        <span class="tag-desconto">
                                            <form action="atualizarDesconto" method="post" >
                                                <input name="desconto" id="inputDesconto" type="text"
                                                    placeholder="${produto.desconto}" />
                                                <button class="btnAtualizar" type="submit" name="atualizar"><i
                                                        class="fa-solid fa-pen"></i></button>
                                            </form>
                                        </span>
                                        <img src="data:image/png;base64,${produto.imagemBase64}" class="produto-capa"
                                            alt="">
                                    </div>
                                    <div>
                                        <form action="atualizarNome" method="post" >
                                            <input name="nome" id="inputNome" type="text"
                                                placeholder="${produto.nome}" />
                                            <button class="btnAtualizar" type="submit" name="atualizar"><i
                                                    class="fa-solid fa-pen"></i></button>
                                        </form>
                                        <div>

                                        </div>
                                        <div id="div-valor">
                                            <span class="valor">
                                                <form action="atualizarValor" method="post" >
                                                    <input name="valor" id="inputValor" type="text"
                                                        placeholder="${produto.valor}" />
                                                    <button class="btnAtualizar" type="submit" name="atualizar"><i
                                                            class="fa-solid fa-pen"></i></button>
                                                </form>
                                            </span>
                                            <span class="preco laranja-texto-3">
                                                <form action="atualizarValorFinal" method="post" >
                                                    <input name="valorFinal" id="inputValorFinal" type="text"
                                                        placeholder="${produto.valorFinal}" />
                                                    <button class="btnAtualizar" type="submit" name="atualizar"><i
                                                            class="fa-solid fa-pen"></i></button>
                                                </form>
                                            </span>
                                        </div>
                                        <div id="quantidade">
                                            <form action="atualizarQuantidade" method="post" >
                                                <input name="quantidade" id="inputQuantidade" type="text"
                                                    placeholder="Quantidade: ${produto.quantidade}" />
                                                <button class="btnAtualizar" type="submit" name="atualizar"><i
                                                        class="fa-solid fa-pen"></i></button>
                                            </form>
                                        </div>
                                        </form>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </main>
                </body>

                </html>