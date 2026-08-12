import java.util.*;

public class BubbleSort<T extends Comparable<T>> {

    private int totalComparacoes = 0;
    private int totalTrocas = 0;

    public int getTotalComparacoes() {
        return totalComparacoes;
    }

    public int getTotalTrocas() {
        return totalTrocas;
    }

    private void troca(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public T[] sort(T[] array, Comparator<T> comparator) {
        int n = array.length;

        this.totalComparacoes = 0;
        this.totalTrocas = 0;

        for (int fase = 1; fase < n; fase++) {
            // j controla comparaçoes
            boolean trocou = false;
            for (int j = 0; j < n - fase; j++) {
                this.totalComparacoes++;
                // compare responsavel por comparar 2 objetos, se compare retornar valor maior
                // que 0, então é maior

                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    troca(array, j, j + 1);
                   trocou = true;
                    this.totalTrocas++;
                }
            }
            if (!trocou) {
                break; // Se não houve trocas, o array já está ordenado
            }
        }

        return array;
    }// fim sort

    public T[] sort(T[] array) {
        return sort(array, (a, b) -> ((Comparable<T>) a).compareTo(b));
    }

    // sort verboso
    public T[] sortVerbose(T[] array, Comparator<T> comparator) {
        int n = array.length;
        int comparacoes = 1;
        int trocas = 0;

        for (int fase = 1; fase < n; fase++) {
            System.out.println("Fase " + fase + ": " + Arrays.toString(array));
            boolean trocou = false;

            for (int j = 0; j < n - fase; j++) {

                
                System.out.println(comparacoes + " Comparação: " + array[j] + " e " + array[j + 1]);
               comparacoes++;

                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    System.out.println("Trocando: " + array[j] + " e " + array[j + 1]);
                    troca(array, j, j + 1);
                    trocas++;
                    System.out.println("Resultado: " + Arrays.toString(array));
                    trocou = true;
                }
            }
            /*if (!trocou) {
                break; // Se não houve trocas, o array já está ordenado
            }*/
        }
        int totalcomp = comparacoes - 1;

        this.totalComparacoes = totalcomp;
        this.totalTrocas = trocas;
        System.out.println("Total de trocas: " + totalTrocas);
        System.out.println("Total de comparações: " + totalcomp);
        return array;
    }// fim sortVerbose

    public T[] sortVerbose(T[] array) {
        return sortVerbose(array, (a, b) -> ((Comparable<T>) a).compareTo(b));
    }

}