package cadastro;

import java.util.Scanner;

public class Comando {

    static Scanner ler = new Scanner(System.in);

    static String[] arrayAux = {"Nome", "Idade", "Sexo", "Cidade", "Estado"};

    public static void cadastrar(String[][] matriz) {

        int linha = pegaUltimoIndiceDaMatriz(matriz) + 1;
        System.out.println("LINHA QUE SERÁ GRAVADA: " + linha);

        if (linha < matriz.length) {
            for (int c = 0; c < matriz[linha].length; c++) {
                System.out.print(arrayAux[c] + ": ");
                matriz[linha][c] = ler.nextLine();
            }
        } else {
            System.out.println(""
                    + "\n<< A lista já está cheia! >>");
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
            if (linha[0] == null) {
                break;
            } else {
                i++;
            }
        }
        System.out.println("ULTIMO INDICE: " + i);
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
            for (int linha = 0; linha < matriz.length; linha++) {
                if (matrizOrdenada[linha][coluna] != null) {
                    for (int c = 0; c < matrizOrdenada[coluna].length; c++) {
                        System.out.println(arrayAux[c] + ": " + matrizOrdenada[linha][c]);
                    }
                }
            }
        }

        //mostra em ordem decrescente
        if (ordem.equals("decrescente")) {
            for (int linha = matriz.length - 1; linha >= 0; linha--) {
                if (matrizOrdenada[linha][0] != null) {
                    for (int c = 0; c < matrizOrdenada[0].length; c++) {
                        System.out.println(arrayAux[c] + ": " + matrizOrdenada[linha][c]);
                    }
                }
            }
        }
    }

    /**
     * Encontra o indice do cabeçalho desejado
     *
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
     * Ordena uma matriz pela coluna especificada
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
            //percorre as linhas da matriz a partir da proxima posição
            for (int linha2 = linha + 1; linha2 < matrizAux.length; linha2++) {
                //se esta linha nao for nula
                if (matrizAux[linha2][coluna] != null) {
                    //compara a linha a ser verificada com as linhas posteriores
                    //String.compareTo(Object): faz uma comparação lexicográfica entre duas strings onde ela:
                    //retorna um inteiro negativo se o valor unicode do objeto string preceder o da string de argumento;
                    //retorna um inteiro positivo se o valor unicode do objeto string suceder o da string de argumento;
                    //retorna zero se o valor unicode do objeto string e o da string de argumento forem iguais.
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

    /**
     * Apaga todos os itens (linhas) de uma matriz
     *
     * @param matriz Matriz original
     */
    public static void apagarTodos(String[][] matriz) {

        //percorre as linhas da matriz inserindo null em todos os campos
        for (int i = 0; i < matriz.length; i++) {
            for (int c = 0; c < matriz[i].length; c++) {
                matriz[i][c] = null;
            }
        }
    }

    /**
     * Localiza e apaga um, ou todos os itens (linhas) de uma matriz
     *
     * @param matriz Matriz original
     * @param valor Valor a ser encontrado
     * @param campo Campo a ser pesquisado
     */
    public static void apagarPorCampo(String[][] matriz, String valor, String campo) {

        int coluna = pegaIndiceDoCabecalho(campo);
        int ultimaLinha = pegaUltimoIndiceDaMatriz(matriz);
        //percorre as linhas da matriz
        for (int linha = 0; linha <= ultimaLinha; linha++) {
            //se encontrar o valor esperado
            if (matriz[linha][coluna].equals(valor)) {
                //se o item encontrado for a ultima linha da matriz
                if (linha == matriz.length - 1) {
                    for (int c = 0; c < matriz[linha].length; c++) {
                        matriz[linha][c] = null;
                    }
                    break;
                } else {
                    //percorre as linhas restantes
                    while (linha < ultimaLinha) {
                        //reposicionando as linhas da matriz
                        matriz[linha] = matriz[linha + 1];
                        linha++;
                    }
                    for (int c = 0; c < matriz[linha].length; c++) {
                        matriz[linha][c] = null;
                    }
                    break;
                }
            }
        }
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

    public static String pegaMedidaDaMatriz(String[][] matriz) {
        return "" + matriz.length + "X" + matriz[0].length;
    }

    public int pegaQuantidadeCadastrado(String[][] matriz) {
        return pegaUltimoIndiceDaMatriz(matriz) + 1;
    }

}
