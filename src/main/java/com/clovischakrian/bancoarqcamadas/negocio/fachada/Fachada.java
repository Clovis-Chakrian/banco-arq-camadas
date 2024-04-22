package com.clovischakrian.bancoarqcamadas.negocio.fachada;

import com.clovischakrian.bancoarqcamadas.dados.repositorios.excecoes.banco.ContaExistenteExcecao;
import com.clovischakrian.bancoarqcamadas.dados.repositorios.excecoes.banco.ContaNaoEncontradaExcecao;
import com.clovischakrian.bancoarqcamadas.negocio.controladores.ContaControlador;
import com.clovischakrian.bancoarqcamadas.negocio.entidades.conta.Conta;

import java.util.List;

public class Fachada implements IFachada {
    private final ContaControlador contaControlador;

    public Fachada() {
        this.contaControlador = new ContaControlador();
    }

    @Override
    public void inserirConta(Conta c) throws ContaExistenteExcecao {
        this.contaControlador.inserirConta(c);
    }

    @Override
    public void alterarConta(Conta c) throws ContaNaoEncontradaExcecao {
        this.contaControlador.alterarConta(c);
    }

    @Override
    public void removerConta(Conta c) throws ContaNaoEncontradaExcecao {
        this.contaControlador.removerConta(c);
    }

    @Override
    public Conta buscarConta(int numero) throws ContaNaoEncontradaExcecao {
        return this.contaControlador.buscarConta(numero);
    }

    @Override
    public boolean verificarExistenciaDeConta(int numero) {
        return this.contaControlador.verificarExistenciaDeConta(numero);
    }

    @Override
    public List<Conta> buscarTodas() {
        return this.contaControlador.buscarTodas();
    }
}
