package com.viden.bandtec.videnws.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idusuario;

    @NotNull
    @NotBlank
    private String nomeUsuario;

    @CPF
    private String cpf;

    @Past
    private Integer dataNascimento;

    @NotNull
    private String celular;

    @Email
    private String email;

    @Min(8)
    @JsonIgnore
    private String senha;

    @ManyToOne
    private Empresa fk_empresa;

    public Integer getId_usuario() {
        return idusuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.idusuario = id_usuario;
    }

    public String getNome_usuario() {
        return nomeUsuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nomeUsuario = nome_usuario;
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
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Empresa getFk_empresa() {
        return fk_empresa;
    }

    public void setFk_empresa(Empresa fk_empresa) {
        this.fk_empresa = fk_empresa;
    }
}
