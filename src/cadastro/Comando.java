package cadastro;

import java.util.Scanner;

public class Comando {
    Scanner ler = new Scanner(System.in);
    
    public static void cadastrar(String[][] matriz){
        for(int i=0; i<matriz[0].length;i++){
            matriz[1][i] = ler.nextLine();
            
        }
        
    }
    public static void listar(String[][] matriz){
        
    }
    public static void apagar(String[][] matriz){
        
    }
    public static void pesquisar(String[][] matriz){
        
    }
    public static void listarTamQuant(String[][] matriz){
        
    }
    public int pegaQuant(String[][] matriz){
        return matriz.length;
    }
    
    
}
