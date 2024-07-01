<%-- Document : cadastro Created on : 16/04/2024, 16:54:48 Author : Senai --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <link rel="shortcut icon" href="./assets/88header.png" type="image/x-icon">
            <link rel="stylesheet" href="./styles/telaCadastro.css">
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Cadastro</title>
            <script src="https://kit.fontawesome.com/abf8e7610f.js" crossorigin="anonymous"></script>
        </head>

        <body>
            <main>
                <div class="cadastro">
                    <form method="post" action="cadastrar" class="formCadastro">
                        <div class="retornoLogin">
                            <h1>Cadastro</h1>
                            <a class="icon-link icon-link-hover" style="--bs-link-hover-color-rgb: 0, 0, 0;"
                                href="./login">
                               Login
                            </a>
                        </div>
                        <p>Digite os seus dados de acesso no campo abaixo.</p>
                        <label for="">Nome</label>
                        <input id="inputNome" name="nome" type="text" placeholder="Digite seu Nome" required />
                        <label for="">Email</label>
                        <input id="inputEmail" name="email" type="email" placeholder="Digite seu Email" required/>
                        <label for="">Senha</label>
                        <input id="inputSenha" name="senha" type="password" placeholder="Digite sua Senha" required />
                        <label for="">Data de Nascimento</label>
                        <input id="inputData" name="data" type="date" required/>
                        <label for="">Cpf</label>
                        <input data-mask="000.000.000-00" data-mask-selectonfocus="true" id="inputCpf" name="Cpf" type="text" placeholder="Digite seu CPF" required/>
                        <label for="">Telefone</label>
                        <input data-mask="(00) 0000-0000" data-mask-selectonfocus="true" id="inputTelefone" name="Telefone" type="tel" placeholder="Digite seu Telefone" required />
                        <button onclick="alert('cadastro efetuado')" type="submit" class="btn">Cadastrar</button>
                    </form>
                </div>
            </main>
            <script src="./scripts/cadastro.js"></script>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.11/jquery.mask.min.js"></script>
        </body>

        </html>