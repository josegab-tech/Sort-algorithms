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
    private static Integer[] gerarVetorAleatorio(int n) {
        Random random = new Random();
        Integer[] vetor = new Integer[n];

        for (int i = 0; i < n; i++) {
            vetor[i] = random.nextInt(n * 10);
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
        Integer[] numeros = carregarArquivo("numeros_aleatorios.txt");
        BubbleSort<Integer> bubbleSort = new BubbleSort<>();

        long inicio = System.currentTimeMillis();    
        //System.out.println("Vetor original: " + Arrays.toString(numeros));
        bubbleSort.sortVerbose(numeros);
      
        //System.out.println("Vetor ordenado: " + Arrays.toString(numeros));
        long fim = System.currentTimeMillis();
        System.out.println("Tempo = "+(fim-inicio)+" ms");
    }
}