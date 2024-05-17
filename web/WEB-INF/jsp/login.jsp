<%-- Document : login Created on : 16/04/2024, 13:57:33 Author : Senai --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <link rel="shortcut icon" href="./assets/88header.png" type="image/x-icon">
            <link rel="stylesheet" href="./styles/login.css">
            <title>Tela de Login</title>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <script src="https://kit.fontawesome.com/abf8e7610f.js" crossorigin="anonymous"></script>

        </head>

        <body>
            <main>
                <div class="page">
                    <div id="formWrapper">
                        <div class="d-flex flex-row justify-content-between">
                            <h1 class="">Login</h1>
                            <a class="icon-link icon-link-hover" style="--bs-link-hover-color-rgb: 0, 0, 0;"
                                href="./cadastro">
                                Cadastre-se
                            </a>
                        </div>
                        <p class="col-12">Digite os seus dados de acesso no campo abaixo.</p>
                        <form method="post" action="logar" id="formLogin">
                            <label for="email">E-mail</label>
                            <input required id="inputE" name="email" type="email" placeholder="Digite seu e-mail" />
                            <label for="password">Senha</label>
                            <input required id="inputS" name="senha" type="password" placeholder="Digite sua senha" />
                            <button type="submit" class="btn text-bg-dark p-0">Entrar</button>
                        </form>
                    </div>
                </div>
            </main>
        </body>
        <script src="./scripts/login.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
            integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
            crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>

        </html>