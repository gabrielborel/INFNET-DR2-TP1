package org.INFNET.TP1;

import java.util.*;

class Cliente {
    private final String nome;
    private final double saldo;

    public Cliente(String nome, double saldo) {
        this.nome = nome;
        this.saldo = saldo;
    }

    public String getNome() { return nome; }
    public double getSaldo() { return saldo; }
}

class FormatadorMoeda {
    public String formatar(double valor) {
        return String.format("R$ %.2f", valor);
    }
}

class RelatorioFinanceiro {
    private final FormatadorMoeda formatador;

    public RelatorioFinanceiro() {
        this.formatador = new FormatadorMoeda();
    }

    public void gerarRelatorio(List<Cliente> clientes) {
        imprimirCabecalho();
        imprimirCorpo(clientes);
        imprimirRodape();
    }

    private void imprimirCabecalho() {
        System.out.println("=== Relatório Financeiro ===");
    }

    private void imprimirCorpo(List<Cliente> clientes) {
        if(clientes.isEmpty()) {
            System.out.println("Nenhum dado disponível");
            return;
        }

        clientes.forEach(cliente ->
                System.out.println("Cliente: " + cliente.getNome() +
                        " - Saldo: " + formatador.formatar(cliente.getSaldo()))
        );
    }

    private void imprimirRodape() {
        System.out.println("===========================");
        System.out.println("Fim do Relatório");
    }
}

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = Arrays.asList(
                new Cliente("João Silva", 1500.75),
                new Cliente("Maria Souza", 24500.20),
                new Cliente("Empresa XYZ", 1500000.00)
        );

        new RelatorioFinanceiro().gerarRelatorio(clientes);
    }
}
