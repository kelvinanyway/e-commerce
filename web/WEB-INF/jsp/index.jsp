<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


    <!DOCTYPE html>
    <html lang="en">

    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="shortcut icon" href="./assets/88header.png" type="image/x-icon">
        <link rel="stylesheet" href="./styles/telaInicial.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://kit.fontawesome.com/abf8e7610f.js" crossorigin="anonymous"></script>
        <title>Mercado 88</title>
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
                            <a class="nav-link active text-dark " aria-current="page">Home</a>
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
            <div id="carouselExampleIndicators" class="carousel slide margin-top">
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0"
                        class="active" aria-current="true" aria-label="Slide 1"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                        aria-label="Slide 2"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
                        aria-label="Slide 3"></button>
                </div>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="./assets/banner4.png" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="./assets/carrossel.jpg" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="./assets/carrossel1.jpg" class="d-block w-100" alt="...">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
                    data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
                    data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
            <div class="container text-center my-3">
                <h2 class="font-weight-light"></h2>
                <div class="row mx-auto my-auto">
                    <div id="recipeCarousel" class="carousel slide w-100" data-ride="carousel">
                        <div class="carousel-inner w-100" role="listbox">
                            <div class="carousel-item active">
                            </div>
                            <c:forEach var="produto" items="${produtos}">
                                <div class="carousel-item">
                                    <div class="col-md-4 mb-3">
                                        <div class="card card-custom">
                                            <div class="card-body">
                                                <div class="imagemProduto">
                                                    <img src="${produto.imagem}" alt="${produto.nome}">
                                                </div>
                                                <h5 class="card-title">${produto.nome}</h5>
                                                <p class="card-text categoria-text">Categoria: ${produto.categoria}</p>
                                                <p class="card-text">Valor: R$ ${produto.valor}</p>
                                                <p class="card-text">Descrição: ${produto.descricao}</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <a class="carousel-control-prev w-auto" href="#recipeCarousel" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon bg-dark border border-dark rounded-circle"
                                aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next w-auto" href="#recipeCarousel" role="button" data-slide="next">
                            <span class="carousel-control-next-icon bg-dark border border-dark rounded-circle"
                                aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
            </div>
            <div class="container text-center my-3">
                <div class="row mx-auto my-auto">
                    <div id="recipeCarousel" class="carousel slide w-100" data-ride="carousel">
                        <div class="carousel-inner w-100" role="listbox">
                            <div class="carousel-item active">
                            </div>
                            <c:forEach var="produto" items="${produtos}">
                                <div class="carousel-item">
                                    <div class="col-md-4 mb-3">
                                        <div class="card card-custom">
                                            <div class="card-body">
                                                <div class="imagemProduto">
                                                    <img src="${produto.imagem}" alt="${produto.nome}">
                                                </div>
                                                <h5 class="card-title">${produto.nome}</h5>
                                                <p class="card-text categoria-text">Categoria: ${produto.categoria}
                                                </p>
                                                <p class="card-text">Valor: R$ ${produto.valor}</p>
                                                <p class="card-text">Descrição: ${produto.descricao}</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <a class="carousel-control-prev w-auto" href="#recipeCarousel" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon bg-dark border border-dark rounded-circle"
                                aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next w-auto" href="#recipeCarousel" role="button" data-slide="next">
                            <span class="carousel-control-next-icon bg-dark border border-dark rounded-circle"
                                aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
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