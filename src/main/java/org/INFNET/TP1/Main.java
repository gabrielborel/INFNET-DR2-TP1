package org.INFNET.TP1;

import java.util.ArrayList;
import java.util.List;

class Livro {
    private final String titulo;
    private boolean disponivel;

    public Livro(String titulo) {
        this.titulo = titulo;
        this.disponivel = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void emprestar() {
        this.disponivel = false;
    }

    public void devolver() {
        this.disponivel = true;
    }
}

class Biblioteca {
    private final List<Livro> livros;

    public Biblioteca() {
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(String titulo) {
        livros.add(new Livro(titulo));
    }

    public void emprestarLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(titulo) && livro.isDisponivel()) {
                livro.emprestar();
                System.out.println("Livro emprestado: " + titulo);
                return;
            }
        }
        System.out.println("Livro não disponível.");
    }

    public void devolverLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(titulo)) {
                livro.devolver();
                System.out.println("Livro devolvido: " + titulo);
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }
}


public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.adicionarLivro("Livro 1");
        biblioteca.adicionarLivro("Livro 2");

        biblioteca.emprestarLivro("Livro 1");
        biblioteca.emprestarLivro("Livro 3");

        biblioteca.emprestarLivro("Livro 1");
        biblioteca.devolverLivro("Livro 1");
        biblioteca.emprestarLivro("Livro 1");
    }
}
