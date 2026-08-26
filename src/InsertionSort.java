import java.util.Comparator;

public class InsertionSort<T extends Comparable<T>> {

    private long contaComparacoes = 0;
    private long contaTrocas = 0;

    public long getContaComparacoes() {
        return this.contaComparacoes;
    }

    public long getContaTrocas() {
        return this.contaTrocas;
    }

    private void troca(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        this.contaTrocas++;
    }

    public T[] sort(T[] array, Comparator<T> comparador) {
        int n = array.length;
        this.contaComparacoes = 0;
        this.contaTrocas = 0;

        for (int i = 1; i < n; i++) {
            int j = i;
            while (j > 0) {
                this.contaComparacoes++;
                if (comparador.compare(array[j - 1], array[j]) > 0) {
                    troca(array, j - 1, j);
                    j--;
                } else {
                    break;
                }
            }
        }

        return array;
    }

    public T[] sort(T[] array) {
        return sort(array, (a, b) -> ((Comparable<T>) a).compareTo(b));
    }
}