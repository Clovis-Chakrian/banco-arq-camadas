package com.clovischakrian.bancoarqcamadas.dados.repositorios.conta;

import com.clovischakrian.bancoarqcamadas.dados.repositorios.excecoes.banco.ContaExistenteExcecao;
import com.clovischakrian.bancoarqcamadas.dados.repositorios.excecoes.banco.ContaNaoEncontradaExcecao;
import com.clovischakrian.bancoarqcamadas.negocio.entidades.conta.Conta;

import java.util.List;

public interface IContaRepositorio {
    public void inserirConta(Conta c) throws ContaExistenteExcecao;
    public void alterarConta(Conta c) throws ContaNaoEncontradaExcecao;
    public void removerConta(Conta c) throws ContaNaoEncontradaExcecao;
    public Conta buscarConta(int numero) throws ContaNaoEncontradaExcecao;
    public boolean verificarExistenciaDeConta(int numero);
    public List<Conta> buscarTodas();
}
