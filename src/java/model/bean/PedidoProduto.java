/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Senai
 */
public class PedidoProduto {
    private int idPedidoProduto;
    private int pedido;
    private int produto;
    private int quantidade;

    public PedidoProduto() {
    }

    public PedidoProduto(int idPedidoProduto, int pedido, int produto, int quantidade) {
        this.idPedidoProduto = idPedidoProduto;
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public int getIdPedidoProduto() {
        return idPedidoProduto;
    }

    public void setIdPedidoProduto(int idPedidoProduto) {
        this.idPedidoProduto = idPedidoProduto;
    }

    public int getPedido() {
        return pedido;
    }

    public void setPedido(int pedido) {
        this.pedido = pedido;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

  
}
