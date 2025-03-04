package org.INFNET.TP1;

import java.util.ArrayList;
import java.util.List;

class Conta {
    private final String nome;
    private double saldo;

    public Conta(String nome, double saldo) {
        if (saldo < 0) {
            throw new IllegalArgumentException("o saldo não pode ser negativo");
        }
        this.nome = nome;
        this.saldo = saldo;
    }

    public String getNome() {
        return this.nome;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void processarPagamento(double taxa) {
        if (taxa < 0) {
            throw new IllegalArgumentException("a taxa não pode ser negativo");
        }
        this.saldo -= taxa;
    }

    public String toString() {
        return "Conta: " + this.getNome() + " - Saldo: " + this.getSaldo();
    }
}

class SistemaFinanceiro {
    private final List<Conta> contas;

    public SistemaFinanceiro() {
        this.contas = new ArrayList<Conta>();
    }

    public void adicionaConta(String nome, double saldo) {
        boolean contaExiste = this.contas.stream().anyMatch(conta -> conta.getNome().equals(nome));
        if (contaExiste) {
            throw new IllegalArgumentException("Conta já existe");
        }
        this.contas.add(new Conta(nome, saldo));
    }

    public void processarPagamento(double taxa) {
        for (Conta conta : this.contas) {
            conta.processarPagamento(taxa);
        }
    }

    public void gerarRelatorio() {
        System.out.println("=== Relatório Financeiro ===");
        if (this.contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada");
        } else {
            for (Conta conta : this.contas) {
                System.out.println(conta);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SistemaFinanceiro sistema = new SistemaFinanceiro();
        sistema.adicionaConta("Conta da Space X", 1500000);
        sistema.adicionaConta("Conta da Blue Origin", 1300000);
        sistema.processarPagamento(2000);
        sistema.gerarRelatorio();
    }
}