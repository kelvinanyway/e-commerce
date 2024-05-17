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
                        <h1>Cadastro</h1>
                        <p>Digite os seus dados de acesso no campo abaixo.</p>
                        <label for="nome">Nome</label>
                        <input id="inputNome" name="nome" type="text" placeholder="Digite seu Nome" required />
                        <label for="email">Email</label>
                        <input id="inputEmail" name="email" type="email" placeholder="Digite seu Email" />
                        <label for="senha">Senha</label>
                        <input id="inputSenha" name="senha" type="password" placeholder="Digite sua Senha" required />
                        <label for="inputData">Data de Nascimento</label>
                        <input id="inputData" name="data" type="date" />
                        <label for="cpf">Cpf</label>
                        <input id="inputCpf" name="Cpf" type="text" placeholder="Digite seu CPF" />
                        <label for="telefone">Telefone</label>
                        <input id="inputTelefone" name="Telefone" type="tel" placeholder="Digite seu Telefone" />
                        <button type="submit" class="btn">Cadastrar</button>
                    </form>
                </div>
            </main>

            <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.11/jquery.mask.min.js"></script>
            <script src="./scripts/cadastro.js"></script>
        </body>

        </html>