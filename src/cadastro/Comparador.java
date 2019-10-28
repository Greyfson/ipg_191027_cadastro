/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro;

/**
 *
 * @author greyf
 */
public class Comparador implements Comparable<String[]> {

    private int index_to_compare;

    public Comparador(int index) {
        index_to_compare = index;
    }

    @Override
    public int compareTo(String[] o) {

    }

    public int compare(Resultado[] elem1, Resultado[] elem2) {
        return compare(elem1, elem2, index_to_compare); // recursividade para tratar diferentes colunas
    }

    public int compare(int[] elem1, int elem2[], int index) {
        if (elem1.length == index) // verifica se ja procurou em todas as colunas
        {
            return 0; // elementos iguais
        }
        if (elem1[index] == elem2[index]) // verifica se os elementos nos indices "index" sao iguais
        {
            return compare(elem1, elem2, index + 1); // verifica na coluna seguinte
        }
        return elem1[index] - elem2[index]; // retorna a diference entre os elementos
    }
}
//
//
//int aux = 0;
//
//		for(int linha = 0; linha < matriz.length; linha++) {
//
//			for(int coluna = 0; coluna < matriz[linha].length; coluna++) {
//
//				int col = coluna;
//				
//				for(int i = linha; i < matriz.length; i++) {		
//
//					for(int j = col+1; j < matriz[i].length; j++) {		
//
//						if (  matriz[linha][coluna] > matriz[i][j] ){
//	   				
//							aux = matriz[linha][coluna];
//							matriz[linha][coluna] = matriz[i][j];
//							matriz[i][j] = aux;
//
//						}
//	   	
//					}
//					
//					col = -1;
//					
//				}
//
//			}
//
//		}