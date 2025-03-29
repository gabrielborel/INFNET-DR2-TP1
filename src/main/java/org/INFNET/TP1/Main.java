package org.INFNET.TP1;

class Servico {
    public void processar(String dado) {
        if (dado == null) {
            throw new NullPointerException("Valor nulo não é permitido");
        }

        if (dado.isEmpty()) {
            throw new IllegalArgumentException("Valor não pode ser vazio");
        }

        System.out.println("Processando: " + dado.toUpperCase());
    }
}

public class Main {
    public static void main(String[] args) {
        Servico servico = new Servico();
        servico.processar("Hello World");
        servico.processar("");
    }
}
