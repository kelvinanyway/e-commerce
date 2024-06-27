<%-- Document : HistoricoPedidos Created on : 18/06/2024, 17:26:46 Author : Senai --%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <%@page contentType="text/html" pageEncoding="UTF-8" %>
                <!DOCTYPE html>
                <html>

                <head>
                    <link rel="stylesheet" href="./styles/historicoPedidos.css">
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
                        rel="stylesheet"
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
                        <div class="div-center">
                            <center>
                                <h1>Historico de Pedidos</h1>
                            </center>
                            <div class="divisao-pedidos m-4">
                                <div class="pedidos-compras w-100">
                                    <div class="d-flex flex-column gap-2 w-100">
                                        <c:forEach items="${pedidos}" var="pedido" varStatus="contagem">
                                            <div class="pedidos">
                                                <div class="labels">
                                                    <div class="id-pedido">
                                                        <span>
                                                            id do seu Pedido:
                                                        </span>
                                                        <span class="d-flex justify-content-center aligth-items-center">
                                                            ${pedido.idPedido}
                                                        </span>
                                                    </div>
                                                    <div class="valor-pedido">
                                                        <span>
                                                            Valor do pedido com frete:
                                                        </span>
                                                        <span class="d-flex justify-content-center aligth-items-center">
                                                            <fmt:formatNumber value="${pedido.valorTotal}"
                                                            type="currency" />
                                                        </span>
                                                    </div>
                                                    <div class="data-pedido">
                                                        <span>
                                                            Data de Entrega do Pedido:
                                                        </span>
                                                        <span class="d-flex justify-content-center aligth-items-center">
                                                            ${pedido.dataPedido}
                                                        </span>
                                                    </div>
                                                </div>
                                                <form class="formExcluir" action="cancelarPedido" method="post">
                                                    <button type="submit" name="cancelarPedido" value="${pedido.idPedido}">
                                                        Cancelar pedido
                                                    </button>
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
                </body>

                </html>