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

    public static void listar(String[][] matriz, String[] arrayAux, String campo) {
        
        int coluna = 0;
        //percorrer cabecalho
        for(int i = 0; i < arrayAux.length; i++)
            //se for o campo buscado
            if(arrayAux[i].equals(campo))
                //guarda o indice do campo (coluna)
                coluna = i;
        
        //organiza pelo campo buscado
        String[][] matrizOrdenada = ordenar(matriz, coluna);
        
        //mostra em ordem crescente
        for (int j = 1; j < matriz.length; j++){
            if (matrizOrdenada[j][0] != null) {
                for (int i = 0; i < matrizOrdenada[0].length; i++){
                    System.out.println(arrayAux[i] + ": " + matrizOrdenada[j][i]);
                }
            }
        }
    }
    
    public static String[][] ordenar(String[][] matriz, int coluna) {
        String aux;
        
        String[][] matriz2 = matriz;
        
        
        for (int linha = 0; linha < matriz2.length; linha++) {
            for (int linha2 = linha + 1; linha2 < matriz2.length; linha2++) {
                if (matriz2[linha][coluna] > matriz2[linha2][coluna]) {
                    for (int col = 0; col < col.length; col++) {
                        aux = matriz2[linha][col];
                        matriz2[linha][col] = matriz2[linha2][col];
                        matriz2[linha2][col] = aux;
                    }
                }
            }
        }
        return matriz2;
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
