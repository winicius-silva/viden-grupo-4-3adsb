package com.viden.bandtec.videnws.dominio;

import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.*;
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
    @NotNull
    private String cpf;

    @NotNull
    private String celular;

    @Email
    @NotNull
    private String email;

    @Size(min = 8)
    @NotNull
    private String senha;

    private Integer fkEmpresa;

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

    public Integer getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Integer fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
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
