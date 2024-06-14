<%--Document : checkout Created on : 04/06/2024, 16:27:59 Author : Senai --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                crossorigin="anonymous">
            <link rel="shortcut icon" href="assets/88header.png" type="image/x-icon">
            <script src="https://kit.fontawesome.com/abf8e7610f.js" crossorigin="anonymous"></script>
            <link rel="stylesheet" href="./styles/adicionarInfo.css">
            <meta http-equiv="Content-Type" name="viewport" content="width=device-width, initial-scale=1.0, text/html; charset=UTF-8">
            <script src="./scripts/compraAPI.js" type="module" defer></script>
            <title>Informações</title>
        </head>

        <body>
            <jsp:include page="header.jsp"></jsp:include>
            <main>
                <div class="container">
                    <center>
                        <h1>Insira seu Endereço</h1>
                    </center>

                    <form action="finalizarEndereco" method="post" name="finalizarPedido">
                        <div class="inputs">
                            <label for="">Cep</label>
                            <input type="text" id="cep" name="cep" required>
                            <label for="">Endereço</label>
                            <input type="text" name="endereco" id="endereco" required>
                            <label for="">Bairro</label>
                            <input type="text" name="bairro" id="bairro" required>
                            <label for="">Cidade</label>
                            <input type="text" name="cidade" id="cidade" required>
                            <label for="">Estado</label>
                            <input type="text" name="estado" id="estado" required>
                            <label for="numero">Numero</label>
                            <input type="text" name="numero" required>
                            <button type="submit" class="btnFinalizar">Adicionar Endereço</button>
                        </div>
                    </form>
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