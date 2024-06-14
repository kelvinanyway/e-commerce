<%-- Document : checkoutFinal Created on : 13/06/2024, 21:10:55 Author : USER --%>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>

            <link rel="stylesheet" href="./styles/checkoutFinalizado.css">
            <link rel="shortcut icon" href="./assets/88header.png" type="image/x-icon">
            <script src="https://kit.fontawesome.com/abf8e7610f.js" crossorigin="anonymous"></script>
            <meta charset="UTF-8">
            <title>Pedido Finalizado</title>
            <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        </head>

        <body class="vh-100">
            <jsp:include page="header.jsp"></jsp:include>
            <main>
                <div class="container-agradecimento">
                    <img src="./assets/gifCompras.gif" alt="gifCompras">
                    <center>
                        <h2>Olá, Tudo bem?
                            <br>
                            Agradecemos muito pela sua compra! Não esqueça de ficar de olho em nossas novidades.
                            Precisando de qualquer coisa, nosso suporte está a um clique de distância.
                        </h2>
                    </center>
                </div>
            </main>
            <footer class="d-flex">
                <p> Mercado88 &copy; todos os direitos reservados</p>
            </footer>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                crossorigin="anonymous"></script>
        </body>

        </html>