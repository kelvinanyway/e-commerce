
create database mercado88;
use mercado88;

create table usuario (
idUsuario int primary key auto_increment,
nome varchar(100) not null,
email varchar(100) not null,
senha varchar(100) not null,
cpf char(14) default "0",
telefone varchar(15) not null,
data date not null,
tipo int default 2,
fotoPerfil longblob
);

create table endereco (
	idEndereco int primary key auto_increment,
    estado varchar(20) not null,
    cidade varchar(50) not null,
    cep char(9),
    bairro varchar(30),
    rua varchar(100) not null,
    numero varchar(10) not null,
    complemento varchar(100)
);

create table categoria (
	idCategoria int primary key auto_increment,
    nome varchar(100) not null
);

create table produto (
	idProduto int primary key auto_increment,
    nome varchar(100) not null,
    valor float(10,2) not null,
    desconto float(10,2) default 0,
    valorFinal float(10,2) GENERATED ALWAYS AS (valor - COALESCE(desconto, 0)) STORED,
    descricao varchar(2000)
);

create table imagem ( 
idImagem int primary key auto_increment,
produto int,
imagem longblob,
formato varchar(10),
foreign key (produto) references produto(idProduto)
);

create table produtoCategoria (
	idProdutoCategoria int primary key auto_increment,
    produto int not null,
    categoria int not null,
    foreign key (produto) references produto(idProduto),
    foreign key (categoria) references categoria(idCategoria)
);


create table estoque (
	idEstoque int primary key auto_increment,
    produto int not null,
    quantidade int not null,
    custo float(10,2) not null,
    foreign key (produto) references produto(idProduto)
);

create table pedido (
	idPedido int primary key auto_increment,
    usuario int not null,
    enderecoEntrega int not null,
    dataPedido date not null,
    valorTotal float,
    status int default 1,
    foreign key (enderecoEntrega) references endereco(idEndereco),
    foreign key (usuario) references usuario(idUsuario)
);

create table carrinho (
	idCarrinho int primary key auto_increment,
    usuario int,
    foreign key (usuario) references usuario(idUsuario)
);

create table carrinhoProduto (
	idCarrinhoProduto int primary key auto_increment,
    carrinho int not null,
    produto int not null,
    foreign key (carrinho) references carrinho(idCarrinho),
    foreign key (produto) references produto(idProduto)
);

create table produtoPedido (
	idProdutoPedido int primary key auto_increment,
    pedido int not null,
    produto int not null,
    foreign key (pedido) references pedido(idPedido),
    foreign key (produto) references produto(idProduto)
);

DELIMITER //
CREATE TRIGGER criarCarrinho
AFTER INSERT ON usuario
FOR EACH ROW
BEGIN
    INSERT INTO carrinho (usuario) VALUES (NEW.idUsuario);
END //

DELIMITER ;

select * from usuario;
select * from produto;
select * from imagem;