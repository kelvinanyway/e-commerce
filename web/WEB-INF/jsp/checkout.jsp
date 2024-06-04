<%-- Document : checkout Created on : 04/06/2024, 16:27:59 Author : Senai --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
            crossorigin="anonymous">
        <link rel="shortcut icon" href="assets/88header.png" type="image/x-icon">
        <script src="https://kit.fontawesome.com/abf8e7610f.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="./styles/checkout.css">
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Checkout</title>
        </head>

        <body>
            <jsp:include page="header.jsp"></jsp:include>
            <main>
                <center><h1>Status do Pedido</h1></center>
                <div class="container">
                    <div class="imagem">
                        <img src="data:image/png;base64,${produto.imagemBase64}">
                    </div>
                    <div class="container-span">
                        <span>Status:</span>
                        <span>Forma de Pagamento:</span>
                        <span>Numero do Pedido:</span>
                        <span>Valor do Pedido:</span>
                        <span>Data do Pedido:</span>
                        <span>Data da Entrega:</span>
                        <span>Detalhes:</span>
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