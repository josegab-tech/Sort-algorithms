import java.util.Comparator;

public class InsertionSort2<T extends Comparable<T>> {
    private long contaComparacoes;
    private long contaDeslocamentos;

    public long getContaComparacoes() {
        return contaComparacoes;
    }

    public long getContaDeslocamentos() {
        return contaDeslocamentos;
    }

    private void insert(T[] v, int i, Comparator<T> comparador) {
        T eleito = v[i];
        int indiceComparacao = i - 1;

        while (indiceComparacao >= 0 && comparador.compare(eleito, v[indiceComparacao]) < 0) {
            
            this.contaComparacoes++;
            this.contaDeslocamentos++;
            v[indiceComparacao + 1] = v[indiceComparacao];
            indiceComparacao--;
        }
        if(indiceComparacao >= 0) {
            this.contaComparacoes++;
        }
        v[indiceComparacao + 1] = eleito;
       
    }

    public T[] sort(T[] array, Comparator<T> comparador) {
        int n = array.length;
        this.contaComparacoes = 0;
        this.contaDeslocamentos = 0;

        for (int i = 1; i < n; i++) {
            insert(array, i, comparador);
        }
        return array;
    }

    public T[] sort(T[] array) {
        return sort(array, (a, b) -> ((Comparable<T>) a).compareTo(b));
    }
}
