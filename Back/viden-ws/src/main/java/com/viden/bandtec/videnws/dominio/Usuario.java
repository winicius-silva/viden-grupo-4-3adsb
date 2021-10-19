package com.viden.bandtec.videnws.dominio;

import javax.persistence.*;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idusuario;

    @Column(name = "nome_usuario")
    private String nome_usuario;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "data_nascimento")
    private Integer dataNascimento;

    @Column(name = "celular")
    private String celular;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "fk_empresa")
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
