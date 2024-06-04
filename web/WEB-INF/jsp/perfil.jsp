<%-- Document : perfil Created on : 03/06/2024, 14:47:04 Author : Senai --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <script src="https://code.jquery.com/jquery-3.7.1.min.js"
                integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
            <script src="https://kit.fontawesome.com/abf8e7610f.js" crossorigin="anonymous"></script>
            <link rel="stylesheet" href="./styles/perfil.css">
            <link rel="shortcut icon" href="./assets/88header.png" type="image/x-icon">
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Perfil</title>
        </head>

        <body>
            <button id="btnVoltar"><a href="./home">Voltar</a></button>
            <a href="./cadastro-de-produto" class="d-none" id="linkadm"><button id="btnAdm"><i
                        class="fa-solid fa-user-tie fa-lg"></i></button></a>
            <main>

                <div class="perfil">
                    <div method="post" action="" class="formPerfil">
                        <center>
                            <h1>Perfil</h1>${adm}
                        </center>
                        <p>Atualize seu perfil quando quiser</p>
                        <label for="nome">Nome</label>
                        <form action="atualizarNome" method="post">
                            <input name="nome" id="inputNome" type="text" placeholder="${usuario.nome}" />
                            <button class="btnAtualizar" type="submit" name="atualizar"><i
                                    class="fa-solid fa-pen"></i></button>
                        </form>
                        <label for="email">Email</label>
                        <form action="atualizarEmail" method="post">
                            <input name="email" id="inputEmail" type="email" placeholder="${usuario.email}" />
                            <button class="btnAtualizar" type="submit" name="atualizar"><i
                                    class="fa-solid fa-pen"></i></button>
                        </form>
                        <label for="senha">Senha</label>
                        <form action="atualizarSenha" method="post">
                            <input name="senha" id="inputSenha" type="password" placeholder="Nova senha" />
                            <button class="btnAtualizar" type="submit" name="atualizar"><i
                                    class="fa-solid fa-pen"></i></button>
                        </form>
                        <label for="telefone">Telefone</label>
                        <form action="atualizarTelefone" method="post">
                            <input id="inputTelefone" name="telefone" type="tel" placeholder="${usuario.telefone}" />
                            <button class="btnAtualizar" type="submit" name="atualizar"><i
                                    class="fa-solid fa-pen"></i></button>
                        </form>
                        <form action="sair" method="post">
                            <button type="submit" value="0" class="btn">Sair</button>
                        </form>
                    </div>
                </div>
            </main>
            <script>
                var valida = '${usuario.tipo}';
                if (valida === '1') {
                    $('#linkadm').removeClass('d-none').addClass('d-flex');
                }
            </script>

        </body>

        </html>