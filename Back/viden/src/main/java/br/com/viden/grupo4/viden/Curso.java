package br.com.viden.grupo4.viden;

public class Curso {

    private Integer id_curso;
    private String nome_curso;
    private String categoria;
    private Double preco;
    private String descricao;
    private Double qtd_pontos;

    public Curso(Integer id_curso, String nome_curso, String categoria, Double preco, String descricao, Double qtd_pontos) {
        this.id_curso = id_curso;
        this.nome_curso = nome_curso;
        this.categoria = categoria;
        this.preco = preco;
        this.descricao = descricao;
        this.qtd_pontos = qtd_pontos;
    }

    public Integer getId_curso() {
        return id_curso;
    }

    public void setId_curso(Integer id_curso) {
        this.id_curso = id_curso;
    }

    public String getnome_curso() {
        return nome_curso;
    }

    public void setnome_curso(String nome_curso) {
        this.nome_curso = nome_curso;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getqtd_pontos() {
        return qtd_pontos;
    }

    public void setqtd_pontos(Double qtd_pontos) {
        this.qtd_pontos = qtd_pontos;
    }
}
