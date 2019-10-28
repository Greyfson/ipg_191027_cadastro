package cadastro;

import java.util.Arrays;
import java.util.Scanner;

public class Principal {
    static Scanner ler = new Scanner(System.in);
    static String[][] matrizCadastro;
    public static void main(String[] args) {
        final int COLUNAS = 5;
//        final int LINHAS = Integer.parseInt(args[0]);
        final int LINHAS =3;
        
        matrizCadastro =  new String[LINHAS][COLUNAS];
        String[] arrayAux = {"Nome", "Idade", "Sexo", "Cidade", "Estado"};
        System.out.println(matrizCadastro.length);
        for(int i=0; i<COLUNAS; i++){
            
            matrizCadastro[0][i] = arrayAux[i];
        }
        String op;
        do{
            menuPrincipal();
            op = ler.nextLine();
            
           switch(op){
               case "1":
                   Comando.cadastrar(matrizCadastro);
                   break;
               case "2":
                   menuListar();
                   break;
               case "3":
                   menuApagar();
                   break;
               case "4":
                   Comando.pesquisar(matrizCadastro);
                   break;
               case "0":
                   break;
               default:
                   System.out.println("Opcao Inválida!");
                   
           }
        }
        while(!op.equals("0"));
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
        
        switch(op){
            case "1":
                String[][] matriz = matrizCadastro;
                Arrays.sort(matriz[1], 1, matriz[1].length);
                Comando.listar(matriz);
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                break;
            case "6":
                break;
            case "0":
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
            switch(op){
            case "1":
                break;
            case "2":
                break;
            case "0":
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }
}