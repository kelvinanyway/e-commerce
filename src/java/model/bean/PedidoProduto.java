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
    private int idProdutoPedido;
    private int idPedido;
    private int idProduto;

    public int getIdProdutoPedido() {
        return idProdutoPedido;
    }

    public void setIdProdutoPedido(int idProdutoPedido) {
        this.idProdutoPedido = idProdutoPedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public PedidoProduto(int idProdutoPedido, int idPedido, int idProduto) {
        this.idProdutoPedido = idProdutoPedido;
        this.idPedido = idPedido;
        this.idProduto = idProduto;
    }

    public PedidoProduto() {
    }
}
