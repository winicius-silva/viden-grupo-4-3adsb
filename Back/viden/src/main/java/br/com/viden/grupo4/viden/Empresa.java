package br.com.viden.grupo4.viden;

public class Empresa {

    private Integer id_empresa;
    private String nome_empresa;
    private String cnpj;
    private String endereco;
    private String email;
    private String senha;

    public Empresa(Integer id_empresa, String nome_empresa, String cnpj, String endereco, String email, String senha) {
        this.id_empresa = id_empresa;
        this.nome_empresa = nome_empresa;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.email = email;
        this.senha = senha;
    }

    public Integer getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(Integer id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getnome_empresa() {
        return nome_empresa;
    }

    public void setnome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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
