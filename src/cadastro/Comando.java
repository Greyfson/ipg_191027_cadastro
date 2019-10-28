package cadastro;

import java.util.Scanner;

public class Comando {

    static Scanner ler = new Scanner(System.in);

    public static void cadastrar(String[][] matriz) {
        for (int i = 0; i < matriz[0].length; i++) {
            System.out.print(matriz[0][i] + ": ");
            matriz[1][i] = ler.nextLine();

        }

    }

    public static void listar(String[][] matriz) {
        for (int j = 1; j < matriz.length; j++) 
            if (matriz[j][0] != null) 
                for (int i = 0; i < matriz[0].length; i++) 
                    System.out.println(matriz[0][i] + ": " + matriz[j][i]);
    }

    public static void apagar(String[][] matriz) {
        

    }

    public static void pesquisar(String[][] matriz) {

    }

    public static void listarTamQuant(String[][] matriz) {

    }

    public int pegaQuant(String[][] matriz) {
        return matriz.length;
    }

}
