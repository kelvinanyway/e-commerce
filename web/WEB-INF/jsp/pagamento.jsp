<%-- Document : pagamento Created on : 11/06/2024, 16:50:18 Author : Senai --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                crossorigin="anonymous">
            <link rel="shortcut icon" href="assets/88header.png" type="image/x-icon">
            <script src="https://kit.fontawesome.com/abf8e7610f.js" crossorigin="anonymous"></script>
            <link rel="stylesheet" href="./styles/pagamento.css">
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Pagamento</title>
        </head>

        <body>
            <jsp:include page="header.jsp"></jsp:include>
            <main>
                <div class="container cartao d-none">
                    <center>
                        <h1>Insira seu Cartão</h1>
                    </center>
                    <div class="inputs">
                        <label for="">Numero Cartão</label>
                        <input type="text" id="nCartao" required>
                        <label for="">CVC</label>
                        <input type="text" id="cvc" required>
                        <label for="">Val</label>
                        <input type="date" id="validade" required>
                        <label for="">Nome Completo do titular</label>
                        <input type="text" id="nCompleto" required>
                        <button class="btnFinalizar">finalizar Compra</button>
                    </div>
                </div>

                <div id="chavepix" class="d-none">
                    <div id="pix">
                        <center>
                            <h1>Nosso pix para pagamento</h1>
                        </center>
                        <img class="img-qr" src="./assets/qrcode.png" alt="qrcode">
                        <button class="btnFinalizar">finalizar Compra</button>
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