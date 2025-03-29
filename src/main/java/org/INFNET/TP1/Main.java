package org.INFNET.TP1;

class ContaBancaria {
    private final String titular;
    private double saldo;

    public ContaBancaria(String titular, double saldo) {
        validarTitular(titular);
        validarSaldoInicial(saldo);
        this.titular = titular;
        this.saldo = saldo;
    }

    private void validarTitular(String titular) {
        if (titular == null || titular.isBlank()) {
            throw new IllegalArgumentException("Titular inválido");
        }
    }

    private void validarSaldoInicial(double saldo) {
        if (saldo < 0) {
            throw new IllegalArgumentException("Saldo inicial não pode ser negativo");
        }
    }

    public void depositar(double valor) {
        validarValorPositivo(valor, "depósito");
        saldo += valor;
    }

    public void sacar(double valor) {
        validarValorPositivo(valor, "saque");
        validarSaldoSuficiente(valor);
        saldo -= valor;
    }

    private void validarValorPositivo(double valor, String operacao) {
        if (valor <= 0) {
            throw new IllegalArgumentException(
                    String.format("Valor do %s deve ser positivo", operacao)
            );
        }
    }

    private void validarSaldoSuficiente(double valor) {
        if (valor > saldo) {
            throw new IllegalStateException("Saldo insuficiente");
        }
    }

    public double getSaldo() {
        return saldo;
    }
}

public class Main {
    public static void main(String[] args) {
       ContaBancaria conta = new ContaBancaria("Conta Bancaria", 10.0);
       conta.sacar(10);
       conta.sacar(10);
    }
}
