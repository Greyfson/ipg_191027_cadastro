package cadastro;

import java.util.Scanner;

/**
 *
 * @author Emerson
 */
public class main {

    public static void main(String[] args) {
        final int COLUNAS = 5;
//        final int LINHAS = Integer.parseInt(args[0]);
        final int LINHAS = 3;
        
        String[][] matrizCadastro =  new String[LINHAS][COLUNAS];
        String[] arrayAux = {"nome", "idade", "sexo", "cidade", "estado"};
        
        for(int i=0; i<COLUNAS; i++){
            
            matrizCadastro[0][i] = arrayAux[i];
        }
        String op;
        Scanner ler = new Scanner(System.in);
        
        do{
            menuPrincipal();
            op = ler.nextLine();
            
           switch(op){
               case "1":
                   Comando.cadastrar(matrizCadastro);
                   break;
               case "2":
                   Comando.listar(matrizCadastro);
                   break;
               case "3":
                   Comando.apagar(matrizCadastro);
                   break;
               case "4":
                   Comando.pesquisar(matrizCadastro);
                   break;
               case "5":
                   Comando.listarTamQuant(matrizCadastro);
                   break;
               case "0":
                   break;
               default:
                   System.out.println("Opcao Inválida!");
                   
           }
        }
        while(op.equals("0"));
        
    }

    public static void menuPrincipal() {
        System.out.println(""
                + "\n1 - Cadastrar Usuários"
                + "\n2 - Listar Cadastros"
                + "\n3 - Apagar Cadastro"
                + "\n4 - Pesquisar Cadastro por Nome"
                + "\n5 - Listar Tamanho/Quantidade"
                + "\n0 - Sair");
    }
    
}