<%-- Document : pagamento Created on : 11/06/2024, 16:50:18 Author : Senai --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                crossorigin="anonymous">
            <link rel="shortcut icon" href="assets/88header.png" type="image/x-icon">
            <script src="https://kit.fontawesome.com/abf8e7610f.js" crossorigin="anonymous"></script>
            <link rel="stylesheet" href="./styles/pagamento.css">
            <meta http-equiv="Content-Type" name="viewport"
                content="width=device-width, initial-scale=1.0, text/html; charset=UTF-8">
            <title>Pagamento</title>
        </head>

        <body>
            <jsp:include page="header.jsp"></jsp:include>
            <main>
                <div class="btns me-5">
                    <center>
                        <h1>Metodos de Pagamentos</h1>
                    </center>
                    <div class="row gap-5">
                        <button class="btnCartao" onclick="mostrarCartao()"><i
                                class="fa-regular fa-credit-card fa-xl"></i></button>
                        <button class="btnPix" onclick="mostrarPix()"><i class="fa-brands fa-pix fa-xl"></i></button>
                    </div>
                </div>
                <div class="cartaoCC d-none flex-column" id="cartao">
                    <center>
                        <h1>Insira seu Cartão</h1>
                    </center>
                    <form action="finalizarPedido" method="post" id="formPagamento">
                        <div class="inputs">
                            <label for="">Numero Cartão</label>
                            <input type="text" id="nCartao" required placeholder="0000 0000 0000 0000">
                            <label for="">CVC</label>
                            <input type="text" id="cvc" required>
                            <label for="">Val</label>
                            <input type="text" id="validade" required placeholder="MM/AA">
                            <label for="">Nome Completo do titular</label>
                            <input type="text" id="nCompleto" required>
                            <button type="submit" class="btnFinalizar">finalizar Compra</button>
                        </div>
                    </form>
                </div>
                <div id="chavepix" class="d-none">
                    <div id="pix">
                        <center>
                            <h1>Nosso pix para pagamento</h1>
                        </center>
                        <img class="img-qr" src="./assets/qrcode.png" alt="qrcode">
                        <form action="finalizarPedido" method="post">
                            <button type="submit" class="btnFinalizar">finalizar Compra</button>
                        </form>

                    </div>
                </div>
            </main>
            <footer>
                <p> Mercado88 &copy; todos os direitos reservados</p>
            </footer>
            <script src="./scripts/pagamento.js"></script>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.11/jquery.mask.min.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                crossorigin="anonymous"></script>

        </body>

        </html>