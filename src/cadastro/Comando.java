package cadastro;

import java.util.Scanner;

public class Comando {

    static Scanner ler = new Scanner(System.in);

    static String[] arrayAux = {"Nome", "Idade", "Sexo", "Cidade", "Estado"};

    public static void cadastrar(String[][] matriz) {

        int idx = pegaUltimoIndiceDaMatriz(matriz);

        if (idx < matriz.length-1) {
            for (int i = 0; i < matriz[idx].length; i++) {
                System.out.print(arrayAux[i] + ": ");
                matriz[idx+1][i] = ler.nextLine();
            }
        } else {
            System.out.println("A lista já está cheia!");
        }
    }

    /**
     * Pega o ultimo indice preenchido da matriz
     *
     * @param matriz Matriz a ser verificada
     * @return retorna o ultimo indice da matriz que está preenchido (-1 se
     * vazio)
     */
    private static int pegaUltimoIndiceDaMatriz(String[][] matriz) {
        int i = -1;
        for (String[] linha : matriz) {
            if (linha == null) {
                break;
            } else {
                i++;
            }
        }
        return i;
    }

    /**
     *
     * @param matriz Matriz original onde está armazenado os dados do cadastro
     * @param campo Campo de cabeçalho que se pretende usar para ordenar
     * @param ordem Tipo de ordenação ["crescente" | "decrescente"]
     */
    public static void listar(String[][] matriz, String campo, String ordem) {

        int coluna = pegaIndiceDoCabecalho(campo);

        //organiza pelo campo buscado
        String[][] matrizOrdenada = ordenar(matriz, coluna);

        //mostra em ordem crescente
        if (ordem.equals("crescente")) {
            for (int j = 1; j < matriz.length; j++) {
                if (matrizOrdenada[j][coluna] != null) {
                    for (int i = 0; i < matrizOrdenada[coluna].length; i++) {
                        System.out.println(arrayAux[i] + ": " + matrizOrdenada[j][i]);
                    }
                }
            }
        }

        //mostra em ordem decrescente
        if (ordem.equals("decrescente")) {
            for (int j = matriz.length - 1; j >= 0; j--) {
                if (matrizOrdenada[j][0] != null) {
                    for (int i = 0; i < matrizOrdenada[0].length; i++) {
                        System.out.println(arrayAux[i] + ": " + matrizOrdenada[j][i]);
                    }
                }
            }
        }
    }

    /**
     * Encontra o indice do cabeçalho desejado
     * @param campo Nome do cabeçalho
     * @return Retorna o indice desejado (-1 se não localizado)
     */
    private static int pegaIndiceDoCabecalho(String campo) {
        int coluna = -1;
        //percorre cabecalho
        for (int i = 0; i < arrayAux.length; i++) {
            //se for o campo buscado
            if (arrayAux[i].equals(campo)) {
                //guarda o indice do campo (coluna)
                coluna = i;
            }
        }
        return coluna;
    }

    /**
     *
     * @param matriz Matriz a ser ordenada
     * @param coluna Coluna que será usada para ordenação
     * @return Retorna uma nova matriz reordenada
     */
    public static String[][] ordenar(String[][] matriz, int coluna) {

        //matriz auxiliar para que a matriz original não seja alterada
        String[][] matrizAux = matriz;
        //variavel que auxilia na troca dos valores de dois campos
        String aux;

        //percorre as linhas da matriz até a penúltima posição
        for (int linha = 0; linha < matrizAux.length - 1; linha++) {
            //se a proxima linha nao for nula
            if (matrizAux[linha + 1][coluna] != null) {
                //percorre as linhas da matriz a partir da proxima posição
                for (int linha2 = linha + 1; linha2 < matrizAux.length; linha2++) {
                    //compara a linha a ser verificada com as linhas posteriores
                    //String.compareTo(Object): faz uma comparação lexicográfica entre duas strings onde ela:
                    //retorna um inteiro negativo se o valor unicode do objeto string preceder o da string de argumento;
                    //retorna um inteiro positivo se o valor unicode do objeto string suceder o da string de argumento;
                    //retorna zero se o valor unicode do objeto string e o da string de argumento forem iguais.
                    System.out.println(""
                            + "\nLINHA " + linha
                            + "\nLINHA2 " + linha2
                            + "\nCOLUNA " + coluna
                            + "\nMATRIZ " + matrizAux[linha][coluna]
                            + "\nMATRIZ2 " + matrizAux[linha2][coluna]);
                    if (matrizAux[linha][coluna].compareTo(matrizAux[linha2][coluna]) > 0) {
                        //percorre as colunas trocando os valores de cada campo
                        for (int col = 0; col < matrizAux[linha].length; col++) {
                            aux = matrizAux[linha][col];
                            matrizAux[linha][col] = matrizAux[linha2][col];
                            matrizAux[linha2][col] = aux;
                        }
                    }
                }
            }
        }

        return matrizAux;
    }

    public static void apagar(String[][] matriz) {

    }

    public static void pesquisar(String[][] matriz, String valor, String campo) {

        int idx = pegaIndiceDoCabecalho(campo);

        //forEach: itera sobre as linhas da matriz
        //cada iteração ele pega uma linha (que, nesse caso, é um array de strings)
        for (String[] linha : matriz) {
            if (linha[idx].contains(valor)) {
                mostrar(linha);
            } else {
                System.out.println("Valor '" + valor + "' não encontrado!");
            }
        }
    }

    private static void mostrar(String[] linha) {
        int i = 0;
        for (String coluna : arrayAux) {
            System.out.println(coluna + ": " + linha[i++]);
        }
    }

    public static void listarTamQuant(String[][] matriz) {

    }

    public int pegaQuant(String[][] matriz) {
        return matriz.length;
    }

}
