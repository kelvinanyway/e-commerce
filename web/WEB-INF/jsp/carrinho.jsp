<%-- Document : carrinho Created on : 20/05/2024, 16:47:54 Author : Senai --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
              crossorigin="anonymous">
        <link rel="shortcut icon" href="./assets/88header.png" type="image/x-icon">
        <link rel="stylesheet" href="./styles/carrinho.css">
        <script src="https://kit.fontawesome.com/abf8e7610f.js" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrinho</title>
    </head>

    <body>
        <header>
            <div id="container-head">
                <nav class="row g-0 justify-content-between align-items-center">
                    <div class="col-2 ">
                        <a href="./home"><img class="img-header align-self-center" src="./assets/88header.png"
                                              alt="img header"></a>
                    </div>
                    <div class="col-md-6">
                        <form class="input-group" action="search" method="get">
                            <button type="submit" class="input-group-text" id="basic-addon1">
                                <i class="fa-solid fa-magnifying-glass"></i>
                            </button>
                            <input type="search" class="form-control" name="S"
                                   placeholder="Pesquise produtos de seu interesse" aria-label="Input group example"
                                   aria-describedby="basic-addon1">
                        </form>
                    </div>
                    <div class="col-2">

                        <div class="row">
                            <a class="col icon-link text-decoration-none text-dark d-flex justify-content-between "
                               style="font-size: 2.5rem ;" href="./login">
                                <i class="fa-solid fa-circle-user"></i>
                            </a>
                            <a class="col icon-link text-decoration-none text-dark d-flex justify-content-between "
                               style="font-size: 2.5rem ;" href="./carrinho">
                                <i class="fa-solid fa-cart-shopping"></i>
                            </a>
                        </div>

                    </div>
                    <ul class="col-12 nav justify-content-center">
                        <li class="nav-item">
                            <a class="nav-link active text-dark " aria-current="page" href="./home">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="./categorias">Categorias</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="#">Contato</a>
                        </li>
                    </ul>
            </div>
        </header>
        <main>
            <div class="carrinho">
                <h1>Carrinho</h1>
                <div>
                    <label for="total"> Total:${produto.valorFinal} </label>
                    <button class="finalizar"> Finalizar Compra</button>
                </div>
            </div>

            <div class="divisao-compras m-4">
                <div class="compras w-100">
                    <div class="d-flex gap-3    ">
                        <input type="checkbox" class="cbox">
                        <img src="data:image/png;base64,${produto.imagemBase64}">

                        <c:forEach items="${carrinho}" var="carrinho">
                            <div class="nvqv">
                                <h2>${produto.nome}</h2>
                                <label for="qntd">Quantidade:</label>
                                <label for="valorUnitario">Valor unit:${produto.valor}</label>
                            </div>
                        </c:forEach>

                    </div>
                    <button class="excluir"><i class="fa-solid fa-trash fa-xl" style="color: #000000;"></i></button>
                </div>
            </div>


        </main>
        <footer>
            <p> Mercado88 &copy; todos os direitos reservados</p>
        </footer>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
                integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
                integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="	https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js"></script>
    </body>
</html>