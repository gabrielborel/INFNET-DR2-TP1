package org.INFNET.TP1;

class Processador {
    public void executar(String v) {
        if (v != null) {
            System.out.println("Processando: " + v);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Processador processador = new Processador();
        processador.executar("java");
    }
}
