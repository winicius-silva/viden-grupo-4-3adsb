package com.viden.bandtec.videnws.dominio;

import javax.persistence.*;

@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpresa;
    private String nome;
    private String cnpj;
    private String endereco;
    private String email;
    private String senha;
    private String duracaoDoContrato;
    private Double valorDoContrato;

    public Empresa(Integer idEmpresa, String nome, String cnpj, String endereco, String email, String senha,
                   String duracaoDoContrato, Double valorDoContrato) {
        this.idEmpresa = idEmpresa;
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.email = email;
        this.senha = senha;
        this.duracaoDoContrato = duracaoDoContrato;
        this.valorDoContrato = valorDoContrato;
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

    public String getDuracaoDoContrato() {
        return duracaoDoContrato;
    }

    public void setDuracaoDoContrato(String duracaoDoContrato) {
        this.duracaoDoContrato = duracaoDoContrato;
    }

    public Double getValorDoContrato() {
        return valorDoContrato;
    }

    public void setValorDoContrato(Double valorDoContrato) {
        this.valorDoContrato = valorDoContrato;
    }

    @Override
    public String toString() {
        return String.format("%8d %-25s %-18s %-40s %-50s %-15s %-25s %12.2f", idEmpresa, nome, cnpj, endereco, email,
                senha, duracaoDoContrato, valorDoContrato);

    }
}
