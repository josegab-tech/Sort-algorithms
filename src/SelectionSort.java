import java.util.Comparator;

public class SelectionSort<T extends Comparable<T>> {
    private long contaComparacoes;
    private long contaTrocas;

    public long getContaComparacoes() {
        return this.contaComparacoes;
    }

    public long getContaTrocas() {
        return this.contaTrocas;
    }

    private int indiceMenorValor(T[] v, int posicao,
            Comparator<T> comparador) {
        int indiceMenor = posicao;

        for (int i = posicao + 1; i < v.length; i++) {
            this.contaComparacoes++;

            if (comparador.compare(v[i], v[indiceMenor]) < 0) {
                indiceMenor = i;
            }
        }

        return indiceMenor;
    }

    void troca(T[] v, int i, int j) {
        T temp = v[i];
        v[i] = v[j];
        v[j] = temp;
        this.contaTrocas++;
    }

    public T[] sort(T[] array, Comparator<T> comparador) {
        int n = array.length;
        this.contaComparacoes = 0;
        this.contaTrocas = 0;

        for (int i = 0; i < n - 1; i++) {
            int indiceMenor = indiceMenorValor(array, i, comparador);
            troca(array, i, indiceMenor);
        }
        return array;
    }

    public T[] sort(T[] array) {
        return sort(array, (a, b) -> ((Comparable<T>) a).compareTo(b));
    }
}
