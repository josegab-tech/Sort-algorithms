import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Appdois {
    /*
     * public static Pessoa[] vetorDePessoas() {
     * return new Pessoa[] {
     * new Pessoa("João", LocalDate.of(1990, 1, 1)),
     * new Pessoa("Ana", LocalDate.of(1992, 2, 2)),
     * new Pessoa("Maria", LocalDate.of(1995, 5, 5)),
     * new Pessoa("Pedro", LocalDate.of(1993, 4, 4)),
     * new Pessoa("Lucas", LocalDate.of(1991, 6, 6)),
     * new Pessoa("Carlos", LocalDate.of(1988, 3, 3)),
     * new Pessoa("Ana", LocalDate.of(1985, 2, 2))
     * };
     * }
     * 
     * public static void main(String[] args) {
     * BubbleSort<Pessoa> bubbleSortPessoas = new BubbleSort<>();
     * Pessoa[] pessoas = vetorDePessoas();
     * ComparadorData comparadorData = new ComparadorData();
     * 
     * Comparator<Pessoa> comparadorNomeData = (p1, p2) -> {
     * int compNome = p1.getNome().compareTo(p2.getNome());
     * 
     * if (compNome != 0) {
     * return compNome;
     * }
     * 
     * return p1.getDataNascimento().compareTo(p2.getDataNascimento());
     * };
     * 
     * bubbleSortPessoas.sort(pessoas, comparadorNomeData);
     * for (Pessoa p : pessoas) {
     * System.out.println(p);
     * }
     */
    public static Integer[] gerarVetorAleatorio(int tamanho) {
        Integer[] vetor = new Integer[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = (int) (Math.random() * 100);
        }
        return vetor;
    }

    // ordenar aqui

    public static Integer[] carregarArquivo(String nomeArquivo) throws IOException {
        List<String> linhas = Files.readAllLines(Paths.get(nomeArquivo));
        Integer[] numeros = new Integer[linhas.size()];
        for (int i = 0; i < linhas.size(); i++) {
            numeros[i] = Integer.parseInt(linhas.get(i).trim());
        }
        return numeros;
    }

    public static void main(String[] args) throws IOException {
        Integer[] numeros = gerarVetorAleatorio(150000);
        Integer[] numerosBubbleSort = numeros.clone();
        Integer[] numerosInsertionSort = numeros.clone();
        BubbleSort<Integer> bubbleSort = new BubbleSort<>();
        SelectionSort<Integer> selectionSort = new SelectionSort<>();
        InsertionSort<Integer> insertionSort2 = new InsertionSort<>();

        //System.out.println("Vetor original: " + Arrays.toString(numeros));
        long inicio = System.currentTimeMillis();
        bubbleSort.sort(numerosBubbleSort);
        long comp = bubbleSort.getTotalComparacoes();
        long trocas = bubbleSort.getTotalTrocas();
        long fim = System.currentTimeMillis();
        int tamanhoVetor = numeros.length;
        System.out.println("Do BubbleSort:");
        System.out.println("Tamanho do vetor = " + tamanhoVetor);
        System.out.println("Total de comparações: " + comp);
        System.out.println("Total de trocas: " + trocas);
        System.out.println("Tempo do BubbleSort = " + (fim - inicio) + " ms\n");

        inicio = 0;
        fim = 0;
        inicio = System.currentTimeMillis();
        selectionSort.sort(numeros);
        fim = System.currentTimeMillis();
        long compSelection = selectionSort.getContaComparacoes();
        long trocasSelection = selectionSort.getContaTrocas();
        System.out.println("Do SelectionSort:");
        System.out.println("Tamanho do vetor = " + tamanhoVetor);
        System.out.println("Total de comparações: " + compSelection);
        System.out.println("Total de trocas: " + trocasSelection);
        System.out.println("Tempo do SelectionSort = " + (fim - inicio) + " ms\n");

        inicio = 0;
        fim = 0;
        inicio = System.currentTimeMillis();
        insertionSort2.sort(numerosInsertionSort);
        fim = System.currentTimeMillis();
        long compInsertion = insertionSort2.getContaComparacoes();
        long trocasInsertion = insertionSort2.getContaDeslocamentos();
        System.out.println("Do InsertionSort:");
        System.out.println("Tamanho do vetor = " + tamanhoVetor);
        System.out.println("Total de comparações: " + compInsertion);
        System.out.println("Total de trocas: " + trocasInsertion);
        System.out.println("Tempo do InsertionSort = " + (fim - inicio) + " ms");


}
}