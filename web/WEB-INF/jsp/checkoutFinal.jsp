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
           <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                crossorigin="anonymous">
        </head>

        <body class="vh-100">
            <jsp:include page="header.jsp"></jsp:include>
            <main>
                <div class="container-agradecimento">
                    <img src="./assets/gifCompras.gif" alt="gifCompras">
                    <center >
                        <span class="fs-3">Olá, Tudo bem?
                            <br>
                            Agradecemos muito pela sua compra! <br> Não esqueça de ficar de olho em nossas novidades 
                            <br>
                            Precisando de qualquer coisa, nosso suporte está a um clique de distância.
                        </span>
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