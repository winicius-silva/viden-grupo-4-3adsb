package com.viden.bandtec.videnws.dominio;

public class Empresa {

    // Atributos
   private Integer idEmpresa;
   private String nome;
   private String cnpj;
   private String endereco;
   private String email;
   private String senha;

   // Construtor
    public Empresa(Integer idEmpresa, String nome, String cnpj, String endereco, String email, String senha) {
        this.idEmpresa = idEmpresa;
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.email = email;
        this.senha = senha;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    @Override
    public String toString() {
        return String.format("%8 %-25s %14d %-40s %-50s %-15s", idEmpresa, nome, cnpj, endereco, email, senha);

    }
}
