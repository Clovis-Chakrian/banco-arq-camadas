package com.clovischakrian.bancoarqcamadas.negocio.entidades.conta;

public class Conta {
    private int numero;
    private int agencia;
    private double saldo;
    private String titular;

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public int getAgencia() {
        return agencia;
    }
    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }

    public boolean equals(Object o) {
        if (o != null) {
            if (o != this) {
                if (o instanceof Conta) {
                    Conta c = (Conta) o;
                    return (c.getNumero() == this.getNumero());
                }
            } else {
                return true;
            }
            return false;
        }
        return false;
    }

    public void exibeConta() {
        System.out.println("\n-----------------------------------------");
        System.out.println("Titular da conta: " + this.getTitular());
        System.out.println("Número da conta: " + this.getNumero());
        System.out.println("Agência da conta: " + this.getAgencia());
        System.out.println("Saldo atual: " + this.getSaldo());
        System.out.println("-----------------------------------------\n");
    }
}
