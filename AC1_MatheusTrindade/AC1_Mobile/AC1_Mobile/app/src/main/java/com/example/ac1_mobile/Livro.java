package com.example.ac1_mobile;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private String categoria;
    private boolean lido;

    public Livro(int id, String titulo, String autor, String categoria, boolean lido) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.lido = lido;
    }

    // Construtor sem ID para inserção de novos livros
    public Livro(String titulo, String autor, String categoria, boolean lido) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.lido = lido;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public boolean isLido() {
        return lido;
    }
}
