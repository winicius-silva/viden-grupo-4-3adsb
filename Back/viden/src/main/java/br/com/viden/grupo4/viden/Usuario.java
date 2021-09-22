package br.com.viden.grupo4.viden;

public class Usuario {

    private Integer id_usuario;
    private Integer fk_empresa;
    private String nome_usuario;
    private String cpf;
    private Integer data_nascimento;
    private String celular;
    private String email;
    private String senha;

    public Usuario(Integer id_usuario, Integer fk_empresa, String nome_usuario, String cpf, Integer data_nascimento, String celular, String email, String senha) {
        this.id_usuario = id_usuario;
        this.fk_empresa = fk_empresa;
        this.nome_usuario = nome_usuario;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.celular = celular;
        this.email = email;
        this.senha = senha;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Integer getFk_empresa() {
        return fk_empresa;
    }

    public void setFk_empresa(Integer fk_empresa) {
        this.fk_empresa = fk_empresa;
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

    public Integer getdata_nascimento() {
        return data_nascimento;
    }

    public void setdata_nascimento(Integer data_nascimento) {
        this.data_nascimento = data_nascimento;
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
}
