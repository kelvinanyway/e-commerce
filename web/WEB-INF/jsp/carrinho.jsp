<%-- Document : carrinho Created on : 20/05/2024, 16:47:54 Author : Senai --%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <%@page contentType="text/html" pageEncoding="UTF-8" %>
                <!DOCTYPE html>
                <html>

                <head>
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
                        rel="stylesheet"
                        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                        crossorigin="anonymous">
                    <link rel="shortcut icon" href="./assets/88header.png" type="image/x-icon">
                    <link rel="stylesheet" href="./styles/carrinho.css">
                    <script src="https://kit.fontawesome.com/abf8e7610f.js" crossorigin="anonymous"></script>
                    <link rel="stylesheet" href="./styles/header.css">
                    <meta http-equiv="Content-Type" name="viewport"
                        content="width=device-width, initial-scale=1.0, text/html; charset=UTF-8">
                    <title>Carrinho</title>
                </head>

                <body>
                    <jsp:include page="header.jsp"></jsp:include>
                    <main>
                        <div class="carrinho">
                            <h1>Carrinho</h1>
                            <span class="fs-3">
                                <span class="fs-3">Total:
                                    <fmt:formatNumber value="${valorTotal}" type="currency" />
                                </span>

                            </span>
                            <a href="./adicionarInfo"><button class="btnPagamento">Finalizar Compra</button></a>
                        </div>
                        <div class="divisao-compras m-4">
                            <div class="compras w-100">
                                <div class="d-flex flex-column gap-2 w-100">
                                    <c:forEach items="${carrinho}" var="produto">
                                        <div class="produtos">
                                            <img src="data:image/png;base64,${produto.imagemBase64}">
                                            <div class="labels">
                                                <h2>${produto.nome}</h2>
                                                <span>Valor unit:
                                                    <fmt:formatNumber value="${produto.valorFinal}" type="currency" />
                                                </span>
                                            </div>
                                            <form class="formExcluir" action="excluir" method="post">
                                                <button type="submit" name="item" value="${produto.idProduto}"><i
                                                        class="fa-solid fa-trash fa-xl"
                                                        style="color: #000000;"></i></button>
                                            </form>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
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
                    <script
                        src="	https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js"></script>
                </body>

                </html>