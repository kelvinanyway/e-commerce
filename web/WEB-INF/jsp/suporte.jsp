<%-- Document : suporte Created on : 15/06/2024, 02:28:04 Author : USER --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <link rel="shortcut icon" href="./assets/88header.png" type="image/x-icon">
            <link rel="stylesheet" href="./styles/suporte.css">
            <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
            <script src="https://kit.fontawesome.com/abf8e7610f.js" crossorigin="anonymous"></script>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Suporte</title>
        </head>

        <body>
            <jsp:include page="header.jsp"></jsp:include>
            <main>
                <center>Suporte Para o Cliente</center> 
                <div class="container-suporte mt-5">
                    <img src="./assets/88header.png" alt="img">
                    <form action="" method="post" id="FormSup">
                        <label for="">Nome</label >
                        <input type="text">
                        <label for="">Email</label>
                        <input type="text" name="" id="">
                        <label for="">Descrição</label>
                        <textarea name="" id="descricao" cols="30" rows="10" placeholder="Mensagem"></textarea>
                        <button id="enviarMensage">Enviar</button>
                    </form>
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