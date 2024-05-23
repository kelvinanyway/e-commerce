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
public class Carrinho {
    private int idCarrinho;
    private int produto;
        private int carrinho;

    public int getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(int idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public int getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(int carrinho) {
        this.carrinho = carrinho;
    }

    public Carrinho(int idCarrinho, int produto, int carrinho) {
        this.idCarrinho = idCarrinho;
        this.produto = produto;
        this.carrinho = carrinho;
    }

    public Carrinho() {
    }
    
}
