package org.INFNET.TP1;

class Processador {

    public void processar(String dado) {
        boolean dadoExiste = this.verificaValidade(dado);
        if (!dadoExiste) {
            System.out.println("Dado inválido.");
            return;
        }

        boolean dadoTamanhoValido = this.verificaTamanho(dado);
        if (!dadoTamanhoValido) {
            System.out.println("Dado muito curto.");
            return;
        }

        System.out.println("Dado válido: " + dado);
    }

    private boolean verificaValidade(String dado) {
        return !dado.isEmpty();
    }

    private boolean verificaTamanho(String dado) {
        int TAMANHO_MINIMO = 10;
        return dado.length() > TAMANHO_MINIMO;
    }
}

public class Main {
    public static void main(String[] args) {
        Processador processador = new Processador();
        processador.processar("Dado 1");
        processador.processar("Dado 2");
        processador.processar("Dado 3");
        processador.processar("Dado 4");
        processador.processar("Dado 567890");
        processador.processar("Dado 56789012313");
        processador.processar("Dado 567890423424");
        processador.processar("Dado 56789034535345");
    }
}