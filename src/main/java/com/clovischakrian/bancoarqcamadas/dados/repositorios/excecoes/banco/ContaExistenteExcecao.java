package com.clovischakrian.bancoarqcamadas.dados.repositorios.excecoes.banco;

import com.clovischakrian.bancoarqcamadas.negocio.entidades.conta.Conta;

public class ContaExistenteExcecao extends Exception {
    public ContaExistenteExcecao() {
    }

    public ContaExistenteExcecao(Conta conta) {
        super("Conta com titular " + conta.getTitular() + " já existe!");
    }
}
