package com.viden.bandtec.videnws.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private LocalDate dataNascimento;

    @NotNull
    private String celular;

    @Email
    private String email;

    @Min(8)
    @JsonIgnore
    private String senha;

    @ManyToOne
    private Empresa fk_empresa;

    @Past
    private LocalDateTime horaCadastro;

    @Past
    private LocalDateTime horaLogin;

    public Integer getIdUsuario() {
        return idusuario;
    }

    public void setIdUsuario(Integer id_usuario) {
        this.idusuario = id_usuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
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

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public LocalDateTime getHoraCadastro() {
        return horaCadastro;
    }

    public void setHoraCadastro(LocalDateTime horaCadastro) {
        this.horaCadastro = horaCadastro;
    }

    public LocalDateTime getHoraLogin() {
        return horaLogin;
    }

    public void setHoraLogin(LocalDateTime horaLogin) {
        this.horaLogin = horaLogin;
    }
}
