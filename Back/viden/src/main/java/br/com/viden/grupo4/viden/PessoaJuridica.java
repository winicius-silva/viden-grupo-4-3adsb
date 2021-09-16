package br.com.viden.grupo4.viden;

public class PessoaJuridica extends Usuario{

    private String cnpj;
    private Double valorPago;

    public PessoaJuridica(String nome, String telefone, String email, String senha, String cnpj) {
        super(nome, telefone, email, senha);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    @Override
    public Double calcularLucro() {
        return valorPago;
    }
}
