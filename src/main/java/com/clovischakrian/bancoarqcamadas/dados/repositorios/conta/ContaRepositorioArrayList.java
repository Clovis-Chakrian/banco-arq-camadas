package com.clovischakrian.bancoarqcamadas.dados.repositorios.conta;

import com.clovischakrian.bancoarqcamadas.dados.repositorios.excecoes.banco.ContaExistenteExcecao;
import com.clovischakrian.bancoarqcamadas.dados.repositorios.excecoes.banco.ContaNaoEncontradaExcecao;
import com.clovischakrian.bancoarqcamadas.negocio.entidades.conta.Conta;

import java.util.ArrayList;

public class ContaRepositorioArrayList implements IContaRepositorio {
    private ArrayList<Conta> contas;

    public ContaRepositorioArrayList() {

        this.contas = new ArrayList<Conta>();
    }

    @Override
    public void inserirConta(Conta c) throws ContaExistenteExcecao {
        try {
            this.buscarConta(c.getNumero());
            throw new ContaExistenteExcecao();
        } catch (ContaNaoEncontradaExcecao excecao) {
            this.contas.add(c);
        }
    }

    @Override
    public void alterarConta(Conta c) throws ContaNaoEncontradaExcecao {
        if (!this.verificarExistenciaDeConta(c.getNumero())) {
            throw new ContaNaoEncontradaExcecao();
        }

        this.contas.set(this.buscarIndiceDeConta(c), c);
    }

    @Override
    public void removerConta(Conta c) throws ContaNaoEncontradaExcecao {
        if (!this.verificarExistenciaDeConta(c.getNumero())) {
            throw new ContaNaoEncontradaExcecao();
        }

        this.contas.remove(c);
    }

    @Override
    public Conta buscarConta(int numero) throws ContaNaoEncontradaExcecao {
        if (!this.verificarExistenciaDeConta(numero)) {
            throw new ContaNaoEncontradaExcecao();
        }

        Conta conta = contas.get(buscarIndiceDeConta(numero));

        return conta;
    }

    private int buscarIndiceDeConta(Conta c) {
        return buscarIndiceDeConta(c.getNumero());
    }

    private int buscarIndiceDeConta(int numero) {
        for (int i = 0; i < this.contas.size(); i++) {
            Conta temp = contas.get(i);
            if (temp.getNumero() == numero)
                return i;
        }
        return -1;
    }

    @Override
    public boolean verificarExistenciaDeConta(int numero) {
        return (this.buscarIndiceDeConta(numero) != -1);
    }

    @Override
    public ArrayList<Conta> buscarTodas() {
        return contas;
    }
}
