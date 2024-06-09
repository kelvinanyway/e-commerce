<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


        <!DOCTYPE html>
        <html lang="en">

        <head>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                crossorigin="anonymous">
            <link rel="shortcut icon" href="./assets/88header.png" type="image/x-icon">
            <link rel="stylesheet" href="./styles/telaInicial.css">
            <link rel="stylesheet" href="./styles/slider.css">
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <script src="https://kit.fontawesome.com/abf8e7610f.js" crossorigin="anonymous"></script>
            <title>Mercado 88</title>
        </head>

        <body class="vh-100">
            <jsp:include page="header.jsp"></jsp:include>
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
                            <img src="./assets/carrossel2.jpg" class="d-block w-100" alt="...">
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
                <div class="container text-center my-5">
                    <h2 class="font-weight-light"></h2>
                    <div class="row mx-auto my-auto">
                        <center>
                            <h1>Nossas Ofertas</h1>
                        </center>

                        <section class="produtos">
                            <button class="pre-btn"><img src="./assets/arrow.png" alt=""></button>
                            <button class="nxt-btn"><img src="./assets/arrow.png" alt=""></button>
                            <div class="produto-container">
                                <c:forEach items="${produtos}" var="produto">
                                    <c:if test="${produto.desconto > 0}">
                                        <div class="produto-card">
                                            <div class="produto-imagem">
                                                <span class="tag-desconto">-R$${produto.desconto}</span>
                                                <img src="data:image/png;base64,${produto.imagemBase64}"
                                                    class="produto-capa" alt="">
                                            </div>
                                            <div>
                                                <span class="produto-info">${produto.nome}</span>
                                                <div>

                                                </div>
                                                <div id="div-valor">
                                                    <span class="valor">R$${produto.valor}</span>
                                                    <span class="preco laranja-texto-3">R$${produto.valorFinal}</span>
                                                </div>
                                                <form action="adicionarcarrinho" method="post" class="carrinho">
                                                    <div id="div-btn">
                                                        <button class="card-btn verde-fundo fs-6" type="submit"
                                                            name="produtoSelecionado"
                                                            value="${produto.idProduto}">Comprar</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </c:if>
                                </c:forEach>
                            </div>
                        </section>
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
            <script src="./scripts/slider.js"></script>
        </body>

        </html>