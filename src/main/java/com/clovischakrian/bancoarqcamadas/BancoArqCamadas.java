/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.clovischakrian.bancoarqcamadas;

import com.clovischakrian.bancoarqcamadas.dados.repositorios.excecoes.banco.ContaExistenteExcecao;
import com.clovischakrian.bancoarqcamadas.dados.repositorios.excecoes.banco.ContaNaoEncontradaExcecao;
import com.clovischakrian.bancoarqcamadas.negocio.entidades.conta.Conta;
import com.clovischakrian.bancoarqcamadas.negocio.fachada.Fachada;
import com.clovischakrian.bancoarqcamadas.negocio.fachada.IFachada;

import java.util.List;
import java.util.Scanner;

/**
 * @author sivolc05
 */
public class BancoArqCamadas {
    public static IFachada fachada = new Fachada();
    public static Scanner scann = new Scanner(System.in);
    public static int numeroContaAtual = 1;
    public static boolean rodarPrograma = true;

    public static void main(String[] args) {
        while (rodarPrograma) {
            try {
                System.out.println("Bem Vindo ao Coffee Bank");
                menu();
                System.out.print("Selecione uma opção: ");
                int opcao = scann.nextInt();
                tomarDecisao(opcao);
            } catch (Exception error) {
                System.out.println(error.getMessage());
            }
        }

    }

    public static void menu() {
        System.out.println("Selecione uma das opções abaixo: ");
        System.out.println("=================================");
        System.out.println("1 - Inserir Conta");
        System.out.println("2 - Alterar Conta");
        System.out.println("3 - Remover Conta");
        System.out.println("4 - Buscar Conta");
        System.out.println("5 - Verificar Existência");
        System.out.println("6 - Listar Contas");
        System.out.println("0 - Sair");
        System.out.println("=================================");
    }

    public static void tomarDecisao(int opcao) throws Exception {
        switch (opcao) {
            case 1:
                inserirConta();
                break;

            case 2:
                alterarConta();
                break;

            case 3:
                removerConta();
                break;

            case 4:
                buscarConta();
                break;

            case 5:
                verificarExistenciaDeConta();
                break;

            case 6:
                buscarTodas();
                break;

            case 0:
                rodarPrograma = false;
                break;

            default:
                System.out.println("A opção selecionada não é válida, tente novamente.");
                break;
        }
    }

    public static void inserirConta() throws ContaExistenteExcecao {
        Conta conta = new Conta();
        conta.setNumero(numeroContaAtual);

        System.out.print("Digite o nome do titular da conta: ");
        conta.setTitular(scann.next());

        System.out.print("Digite o número da agência: ");
        conta.setAgencia(scann.nextInt());

        System.out.print("Saldo inicial: ");
        conta.setSaldo(scann.nextDouble());

        fachada.inserirConta(conta);

        numeroContaAtual++;
        System.out.println("Conta adicionada com sucesso!");
    }

    public static void alterarConta() throws ContaNaoEncontradaExcecao {
        Conta conta = new Conta();

        System.out.print("Digite o número da conta: ");
        conta.setNumero(scann.nextInt());

        System.out.print("Digite o nome do titular da conta: ");
        conta.setTitular(scann.next());

        System.out.print("Digite o número da agência: ");
        conta.setAgencia(scann.nextInt());

        System.out.print("Saldo inicial: ");
        conta.setSaldo(scann.nextDouble());

        fachada.alterarConta(conta);
        System.out.println("Conta atualizada com sucesso.");
    }

    public static void removerConta() throws ContaNaoEncontradaExcecao {
        Conta conta = new Conta();

        System.out.print("Digite o número da conta: ");
        conta.setNumero(scann.nextInt());

        fachada.removerConta(conta);

        System.out.println("Conta removida com sucesso!");
    }

    public static void buscarConta() throws ContaNaoEncontradaExcecao {
        System.out.print("Digite o número da conta: ");

        Conta conta = fachada.buscarConta(scann.nextInt());

        conta.exibeConta();
    }

    public static void verificarExistenciaDeConta() {
        System.out.print("Digite o número da conta: ");
        boolean contaExiste = fachada.verificarExistenciaDeConta(scann.nextInt());

        if (contaExiste) System.out.println("A conta buscada existe.");
        else System.out.println("A conta buscada não existe.");
    }

    public static void buscarTodas() {
        List<Conta> contas = fachada.buscarTodas();

        System.out.println("Contas armazenadas:");
        System.out.println("=================================");
        for (Conta c : contas) {
            c.exibeConta();
        }
        System.out.println("=================================");
    }
}
