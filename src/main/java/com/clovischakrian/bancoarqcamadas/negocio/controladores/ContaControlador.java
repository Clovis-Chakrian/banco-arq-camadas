package com.clovischakrian.bancoarqcamadas.negocio.controladores;

import com.clovischakrian.bancoarqcamadas.dados.repositorios.conta.ContaRepositorioArrayList;
import com.clovischakrian.bancoarqcamadas.dados.repositorios.conta.IContaRepositorio;
import com.clovischakrian.bancoarqcamadas.dados.repositorios.excecoes.banco.ContaExistenteExcecao;
import com.clovischakrian.bancoarqcamadas.dados.repositorios.excecoes.banco.ContaNaoEncontradaExcecao;
import com.clovischakrian.bancoarqcamadas.negocio.entidades.conta.Conta;

import java.util.List;

public class ContaControlador {
    private final IContaRepositorio contaRepositorio;

    public ContaControlador() {
        this.contaRepositorio = new ContaRepositorioArrayList();
    }

    public void inserirConta(Conta c) throws ContaExistenteExcecao {
        this.contaRepositorio.inserirConta(c);
    }

    public void alterarConta(Conta c) throws ContaNaoEncontradaExcecao {
        this.contaRepositorio.alterarConta(c);
    }

    public void removerConta(Conta c) throws ContaNaoEncontradaExcecao {
        this.contaRepositorio.removerConta(c);
    }

    public Conta buscarConta(int numero) throws ContaNaoEncontradaExcecao {
        return this.contaRepositorio.buscarConta(numero);
    }

    public boolean verificarExistenciaDeConta(int numero) {
        return this.contaRepositorio.verificarExistenciaDeConta(numero);
    }

    public List<Conta> buscarTodas() {
        return this.contaRepositorio.buscarTodas();
    }
}
