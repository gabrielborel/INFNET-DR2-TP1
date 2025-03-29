package org.INFNET.TP1;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class Conta {
    private String titular;
    private double saldo;

    public Conta(String titular, double saldoInicial) {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("saldo não pode ser menor que zero");
        }
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public String getTitular() { return titular; }
    public double getSaldo() { return saldo; }

    public void debitar(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("o valor a ser creditado não pode ser negativo");
        }
        this.saldo -= valor;
    }

    public void creditar(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("o valor a ser creditado não pode ser negativo");
        }
        this.saldo += valor;
    }
}

class ServicoBancario {
    private final Map<String, Conta> contas = new HashMap<>();

    public void criarConta(String titular, double saldoInicial) {
        Conta conta = new Conta(titular, saldoInicial);
        this.contas.put(conta.getTitular(), conta);
    }

    public void transferir(String origem, String destino, double valor) {
        Conta contaOrigem = Optional.ofNullable(contas.get(origem))
                .orElseThrow(() -> new IllegalArgumentException("Conta origem não encontrada"));

        Conta contaDestino = Optional.ofNullable(contas.get(destino))
                .orElseThrow(() -> new IllegalArgumentException("Conta destino não encontrada"));

        if(contaOrigem.getSaldo() < valor) {
            throw new IllegalStateException("Saldo insuficiente");
        }

        contaOrigem.debitar(valor);
        contaDestino.creditar(valor);
    }
}

class ConsoleInterface {
    private final ServicoBancario servico;

    public ConsoleInterface(ServicoBancario servico) {
        this.servico = servico;
    }

    public void iniciar() {
        servico.criarConta("Cliente A", 1000);
        servico.criarConta("Cliente B", 500);

        try {
            servico.transferir("Cliente A", "Cliente B", 300);
            System.out.println("Transferência realizada com sucesso");
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}


public class Main {
    public static void main(String[] args) {
        ServicoBancario servicoBancario = new ServicoBancario();
        ConsoleInterface interfaceBancaria = new ConsoleInterface(servicoBancario);
        interfaceBancaria.iniciar();
    }
}
