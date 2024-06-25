<%-- Document : HistoricoPedidos Created on : 18/06/2024, 17:26:46 Author : Senai --%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@page contentType="text/html" pageEncoding="UTF-8" %>
            <!DOCTYPE html>
            <html>

            <head>
                <link rel="stylesheet" href="./styles/historicoPedidos.css">
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
                    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                    crossorigin="anonymous">
                <link rel="shortcut icon" href="./assets/88header.png" type="image/x-icon">
                <link rel="stylesheet" href="./styles/header.css">
                <script src="https://kit.fontawesome.com/abf8e7610f.js" crossorigin="anonymous"></script>

                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>Pedidos</title>
            </head>

            <body>
                <jsp:include page="header.jsp"></jsp:include>
                <main>
                    <center>Historico de Pedidos</center>
                    <c:forEach items="${pedidos}" var="pedido" varStatus="contagemPedido">
                        <c:forEach var="item" items="${itensDoPedido[contagemPedido.index]}" varStatus="contagem">
                            <li>
                                <div class="produto-imagem">
                                    <img src="data:image/png;base64,${item.imagemBase64}" alt="">
                                </div>
                                <div class="produto-detalhes">
                                    <div class="detalhes-nome">
                                        <span>
                                            ${item.nome}
                                        </span>
                                    </div>
                                    <div class="detalhes-qtd">
                                        <span>
                                            Quantidade:
                                        </span>
                                        <span>
                                            ${produtopedido[contagemPedido.index].produtoPedido[contagem.index].quantidade}
                                        </span>
                                    </div>
                                    <div class="detalhes-total">
                                        <span>
                        </c:forEach>

                    </c:forEach>
                </main>
                <footer>
                    <p> Mercado88 &copy; todos os direitos reservados</p>
                </footer>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                    crossorigin="anonymous"></script>
            </body>

            </html>