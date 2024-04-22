package com.clovischakrian.bancoarqcamadas.dados.repositorios.excecoes.banco;

public class ContaNaoEncontradaExcecao extends Exception {
    public ContaNaoEncontradaExcecao() {
    }

    public ContaNaoEncontradaExcecao(int numero) {
        super("Conta de número " + numero + " não encontrada!");
    }
}
