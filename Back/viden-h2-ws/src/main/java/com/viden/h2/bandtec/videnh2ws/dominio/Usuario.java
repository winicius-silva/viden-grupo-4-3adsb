package com.viden.h2.bandtec.videnh2ws.dominio;

import javax.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idusuario;
    private String nome_usuario;
    private String cpf;
    private Integer dataNascimento;
    private String celular;
    private String email;
    private String senha;
    private Integer fk_empresa_usuario;

    public Integer getId_usuario() {
        return idusuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.idusuario = id_usuario;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Integer dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return null;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getFk_empresa_usuario() {
        return fk_empresa_usuario;
    }

    public void setFk_empresa_usuario(Integer fk_empresa_usuario) {
        this.fk_empresa_usuario = fk_empresa_usuario;
    }
}
