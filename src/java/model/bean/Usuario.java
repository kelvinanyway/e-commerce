/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.sql.Date;

/**
 *
 * @author Senai
 */
public class Usuario {
    private int idUsuario;
    private String nome;
    private String email;
    private String senha;
    private Date data;
    private String cpf;
    private String telefone;
    private int tipo;
    private byte[] fotodeperfil;
    private String fotodeperfilBase64;

    public String getFotodeperfilBase64() {
        return fotodeperfilBase64;
    }

    public void setFotodeperfilBase64(String fotodeperfilBase64) {
        this.fotodeperfilBase64 = fotodeperfilBase64;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public byte[] getFotodeperfil() {
        return fotodeperfil;
    }

    public void setFotodeperfil(byte[] fotodeperfil) {
        this.fotodeperfil = fotodeperfil;
    }

    public Usuario(int idUsuario, String nome, String email, String senha, Date data, String cpf, String telefone, int tipo, byte[] fotodeperfil) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.data = data;
        this.cpf = cpf;
        this.telefone = telefone;
        this.tipo = tipo;
        this.fotodeperfil = fotodeperfil;
    }

    public Usuario() {
    }
}