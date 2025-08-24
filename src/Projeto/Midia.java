package Projeto;

public class Midia {
    private String nome;
    private String autor;
    private double duracao;
    private TipoMidia tipo;
    private String genero;

    public Midia (String nome, String autor, double duracao){
        this.nome = nome;
        this.autor = autor;
        this.duracao = duracao;
        this.tipo = tipo;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }

    public double getDuracao() {
        return duracao;
    }

    public TipoMidia getTipo(){
        return tipo;
    }

    public String getGenero(){
        return genero;
    }
}