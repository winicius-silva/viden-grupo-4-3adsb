package br.com.viden.grupo4.viden;

public class PessoaFisica extends Usuario {

    private String cpf;
    private Double duracaoVideo;
    private Double porcentagem;

    public PessoaFisica(String nome, String telefone, String email, String senha, String cpf) {
        super(nome, telefone, email, senha);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public Double calcularLucro() {
        return duracaoVideo * porcentagem;
    }
}
