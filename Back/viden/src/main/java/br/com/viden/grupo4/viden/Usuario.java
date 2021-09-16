package br.com.viden.grupo4.viden;

public abstract class Usuario {

    private String nome;
    private String telefone;
    private String email;
    private String senha;
    private Boolean autenticado;

    public Usuario(String nome, String telefone, String email, String senha) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }


    public String getEmail() {
        return email;
    }


    protected String getSenha() {
        return senha;
    }

    public Boolean getAutenticado() {
        return autenticado;
    }

    public void setAutenticado(Boolean autenticado) {
        this.autenticado = autenticado;
    }

    public abstract Double calcularLucro();
}
