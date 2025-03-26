package org.INFNET.TP1;

import java.util.ArrayList;
import java.util.List;

class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double calcularValorTotal() {
        return preco * quantidade;
    }
}

class CarrinhoDeCompras {
    private final List<Produto> itens;

    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        itens.add(produto);
    }

    private double calcularTotal() {
        return itens.stream()
                .mapToDouble(Produto::calcularValorTotal)
                .sum();
    }

    public void exibirResumo() {
        System.out.println("Resumo da Compra:");
        itens.forEach(item -> System.out.printf(
                "%s x%d: R$ %.2f%n",
                item.getNome(),
                item.getQuantidade(),
                item.getPreco() * item.getQuantidade()
        ));
        System.out.printf("Total: R$ %.2f%n", calcularTotal());
    }
}

public class Main {
    public static void main(String[] args) {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.adicionarProduto(
                new Produto("Banana", 5, 10)
        );
        carrinho.adicionarProduto(
                new Produto("Uva", 2, 32)
        );
        carrinho.exibirResumo();
    }
}
