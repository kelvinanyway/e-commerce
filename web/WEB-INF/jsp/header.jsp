<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./styles/header.css">
        <title>Document</title>
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
                        <input type="search" class="form-control" name="s"
                            placeholder="Pesquise produtos de seu interesse" aria-label="Input group example"
                            aria-describedby="basic-addon1">
                    </form>
                </div>
                <div class="col-3">

                    <div class="row">
                        <a class="col icon-link text-decoration-none text-dark d-flex justify-content-between "
                            style="font-size: 2.5rem ;" href="./perfil">
                            <i class="fa-solid fa-circle-user"></i>
                        </a>
                        <a class="col icon-link text-decoration-none text-dark d-flex justify-content-between "
                            style="font-size: 2.5rem ;" href="./carrinho">
                            <i class="fa-solid fa-cart-shopping"></i>
                        </a>
                        <a class="col icon-link text-decoration-none text-dark d-flex justify-content-between "
                            style="font-size: 2.5rem ;" href="">
                            <i class="fa-solid fa-box"></i>
                        </a>


                        <div class="dropdown">
                            <button class="btn btn-secondary dropdown-toggle bg-dark" type="button" id="dropdownMenu2"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fa-solid fa-bars"></i>
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
                                <button class="dropdown-item" type="button">
                                    <a class="col icon-link text-decoration-none text-dark d-flex "
                                        style="font-size: 2.5rem ;" href="./perfil">
                                        <i class="fa-solid fa-circle-user"></i> <span class="fs-6 ">Perfil</span>
                                    </a>
                                </button>
                                <button class="dropdown-item" type="button">
                                    <a class="col icon-link text-decoration-none text-dark d-flex justify-content-between "
                                        style="font-size: 2.5rem ;" href="./carrinho">
                                        <i class="fa-solid fa-cart-shopping"></i><span class="fs-6 ">Carrinho</span>
                                    </a>
                                </button>
                                <button class="dropdown-item" type="button">
                                    <a class="col icon-link text-decoration-none text-dark d-flex justify-content-between "
                                        style="font-size: 2.5rem ;" href="">
                                        <i class="fa-solid fa-box"></i><span class="fs-6 ">contato</span>
                                    </a>
                                </button>
                            </div>
                        </div>

                    </div>

                </div>
                <ul class="col-12 nav justify-content-center">
                    <li class="nav-item">
                        <a class="nav-link active text-dark " aria-current="page" href="./home">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-dark" href="./categorias">Produtos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-dark" href="#">Contato</a>
                    </li>
                </ul>
        </div>
    </header>
</body>

</html>