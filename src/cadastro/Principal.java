package cadastro;

import java.util.Arrays;
import java.util.Scanner;

public class Principal {

    static Scanner ler = new Scanner(System.in);
    static String[][] matrizCadastro;

    public static void main(String[] args) {

        final int COLUNAS = Comando.arrayAux.length;
//        final int LINHAS = Integer.parseInt(args[0]);
        final int LINHAS = 3;

        matrizCadastro = new String[LINHAS][COLUNAS];
        System.out.println("TAMANHO DA MATRIZ: "+ matrizCadastro.length+"X"+matrizCadastro[0].length);

        String op;
        do {
            menuPrincipal();
            op = ler.nextLine();

            switch (op) {
                case "1": //Cadastrar Usuários
                    Comando.cadastrar(matrizCadastro);
                    break;
                case "2": //Listar Cadastros
                    menuListar();
                    break;
                case "3": //Apagar Cadastro
                    menuApagar();
                    break;
                case "4": //Pesquisar Cadastro por Nome
//                    Comando.pesquisar(matrizCadastro,valor, arrayAux, "Nome");
                    break;
                case "5": //Listar Tamanho/Quantidade
                    break;
                case "0": //Sair do programa
                    break;
                default:
                    System.out.println("Opcao Inválida!");

            }
        } while (!op.equals("0"));
    }

    public static void menuPrincipal() {
        System.out.print("\tMENU PRINCIPAL"
                + "\n1 - Cadastrar Usuários"
                + "\n2 - Listar Cadastros"
                + "\n3 - Apagar Cadastro"
                + "\n4 - Pesquisar Cadastro por Nome"
                + "\n5 - Listar Tamanho/Quantidade"
                + "\n0 - Sair"
                + "\n>>: ");
    }

    public static void menuListar() {
        System.out.print("\tLISTAR"
                + "\n1 - Listar por ordem alfabética"
                + "\n2 - Listar por ordem crescente de idade"
                + "\n3 - Listar por cadastro do sexo feminino"
                + "\n4 - Listar por cadastro de sexo masculino"
                + "\n5 - Listar tamanho da matriz"
                + "\n6 - Listar quantidade de usuários cadastrados"
                + "\n0 - Voltar ao menu principal"
                + "\n>>: ");
        String op = ler.nextLine();

        switch (op) {
            case "1": //Listar por ordem alfabética
                Comando.listar(matrizCadastro, "Nome", "crescente");
                break;
            case "2": //Listar por ordem crescente de idade
                break;
            case "3": //Listar por cadastro do sexo feminino
                break;
            case "4": //Listar por cadastro do sexo masculino
                break;
            case "5": //Listar tamanho da matriz
                break;
            case "6": //Listar quantidade de usuários cadastrados
                break;
            case "0": //Voltar ao menu principal
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    public static void menuApagar() {
        System.out.print("\tAPAGAR"
                + "\n1 - Apagar por nome"
                + "\n2 - Apagar todos"
                + "\n0 - Voltar ao menu principal"
                + "\n>>: ");
        String op = ler.nextLine();
        switch (op) {
            case "1": //Apagar por nome
                break;
            case "2": //Apagar todos
                break;
            case "0": //Voltar ao menu principal
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }
}
