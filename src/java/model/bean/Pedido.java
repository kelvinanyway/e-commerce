/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 *
 * @author Senai
 */
public class Pedido {

    private int idPedido;
    private int usuario;
    private int enderecoEntrega;
    private Date dataPedido;
    private Float valorTotal;
    private int Status;

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public void setDataPedido() {
        SimpleDateFormat formatoData = new SimpleDateFormat();
        LocalDate localDate = LocalDate.now();
        Date data = java.sql.Date.valueOf(localDate);
        this.dataPedido = data;
    }

    public int getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(int enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public Pedido(int idPedido, int usuario, int enderecoEntrega, Date dataPedido, Float valorTotal, int Status) {
        this.idPedido = idPedido;
        this.usuario = usuario;
        this.enderecoEntrega = enderecoEntrega;
        this.dataPedido = dataPedido;
        this.valorTotal = valorTotal;
        this.Status = Status;
    }

    public Pedido() {
    }
}
