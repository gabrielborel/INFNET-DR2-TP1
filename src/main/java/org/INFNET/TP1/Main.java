package org.INFNET.TP1;

class Pedido {
    private final int id;
    private final String descricao;
    private final double valor;

    public Pedido(int id, String descricao, double valor) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getId() { return id; }
    public String getDescricao() { return descricao; }
    public double getValor() { return valor; }
}

public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido(1, "Comida", 10.0);
        System.out.println("ID do pedido: " + pedido.getId());
        System.out.println("Nome do pedido: " + pedido.getDescricao());
        System.out.println("Valor do pedido: " + pedido.getValor());
    }
}
