<%-- Document : perfil Created on : 03/06/2024, 14:47:04 Author : Senai --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <script src="https://kit.fontawesome.com/abf8e7610f.js" crossorigin="anonymous"></script>
            <link rel="stylesheet" href="./styles/perfil.css">
            <link rel="shortcut icon" href="./assets/88header.png" type="image/x-icon">
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Perfil</title>
        </head>

        <body>
            <button id="btnVoltar"><a href="./home">Voltar</a></button>
            <main>

                <div class="perfil">
                    <div method="post" action="" class="formPerfil">
                        <center>
                            <h1>Perfil</h1>
                        </center>
                        <p>Atualize seu perfil quando quiser</p>
                        <label for="nome">Nome</label>
                        <form action="" method="post" >
                            <input id="inputNome" name="nome" type="text" placeholder="${usuario.nome}" />
                            <button type="submit" name="atualizar"><i class="fa-solid fa-pen"></i></button>
                        </form>
                        <label for="email">Email</label>
                        <form action="" method="" >
                            <input id="inputEmail" name="email" type="email" placeholder="${usuario.email}" />
                            <button type="submit" name="atualizar"><i class="fa-solid fa-pen"></i></button>
                        </form>
                        <label for="senha">Senha</label>
                        <form action="" method="post" >
                            <input id="inputSenha" name="senha" type="password" placeholder="Nova senha" />
                            <button class="ms-1" type="submit" name="atualizar"><i class="fa-solid fa-pen"></i></button>
                        </form>
                        <label for="telefone">Telefone</label>
                        <form action="" method="post" >
                            <input id="inputTelefone" name="Telefone" type="tel" placeholder="${usuario.telefone}" />
                            <button type="submit" name="atualizar"><i class="fa-solid fa-pen"></i></button>
                        </form>
                        <form action="">
                            <button type="submit" class="btn">Sair</button>
                        </form>
                    </div>
                </div>
            </main>
        </body> 
        </html>