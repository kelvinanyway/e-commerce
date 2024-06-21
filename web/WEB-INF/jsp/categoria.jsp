<%-- Document : carrinho Created on : 20/05/2024, 16:47:54 Author : Senai --%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <%@page contentType="text/html" pageEncoding="UTF-8" %>
            <!DOCTYPE html>
            <html>

            <head>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
                    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                    crossorigin="anonymous">
                <link rel="shortcut icon" href="assets/88header.png" type="image/x-icon">
                <link rel="stylesheet" href="./styles/categorias.css">
                <link rel="stylesheet" href="./styles/slider.css">
                <link rel="stylesheet" href="./styles/header.css">
                <script src="https://kit.fontawesome.com/abf8e7610f.js" crossorigin="anonymous"></script>
                <meta http-equiv="Content-Type" name="viewport" content="width=device-width, initial-scale=1.0, text/html; charset=UTF-8">
                <title>Categorias</title>
            </head>

            <body>
               <jsp:include page="header.jsp"></jsp:include>
                <main>
                    <center>
                        <h1>Produtos</h1>
                    </center>
                    <div class="produto row">
                        <c:forEach items="${produtos}" var="produto">
                            <div class="produto-card">
                                <div class="produto-imagem">
                                    <span class="tag-desconto">-<fmt:formatNumber value="${produto.desconto}" type="currency" /></span>
                                    <img src="data:image/png;base64,${produto.imagemBase64}" class="produto-capa"
                                        alt="">
                                </div>
                                <div>
                                    <span class="produto-info">${produto.nome}</span>
                                    <div>

                                    </div>
                                    <div id="div-valor">
                                        <span class="valor"><fmt:formatNumber value="${produto.valor}" type="currency" /></span>
                                        <span class="preco laranja-texto-3"><fmt:formatNumber value="${produto.valorFinal}" type="currency" /></span>
                                    </div>
                                    <form action="adicionacarrinho" method="post" class="carrinho">
                                        <div id="div-btn">
                                            <button class="card-btn verde-fundo fs-6" type="submit"
                                                name="produtoSelecionado" value="${produto.idProduto}">Comprar</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </main>
                <footer>
                    <p> Mercado88 &copy; todos os direitos reservados</p>
                </footer>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                    crossorigin="anonymous"></script>
                <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
                    integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
                    crossorigin="anonymous"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
                    integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
                    crossorigin="anonymous"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
                <script src="	https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js"></script>
            </body>

            </html>