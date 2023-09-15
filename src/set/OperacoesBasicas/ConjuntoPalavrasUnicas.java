package set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;
public class ConjuntoPalavrasUnicas {

    private Set<String> conjuntoPalavras;

    public ConjuntoPalavrasUnicas() {
        conjuntoPalavras = new HashSet<>();
    }

    public void adicionarPalavra(String palavra) {
        conjuntoPalavras.add(palavra);
    }

    public void removerPalavra(String palavra) {
        conjuntoPalavras.remove(palavra);
    }

    public boolean verificarPalavra(String palavra) {
        return conjuntoPalavras.contains(palavra);
    }

    public void exibirPalavrasUnicas() {
        for (String palavra : conjuntoPalavras) {
            System.out.println(palavra);
        }
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjunto = new ConjuntoPalavrasUnicas();

        conjunto.adicionarPalavra("Java");
        conjunto.adicionarPalavra("Kotlin");
        conjunto.adicionarPalavra("C++");
        conjunto.adicionarPalavra("Java"); // Tentativa de adicionar uma palavra repetida

        System.out.println("Palavras no conjunto:");
        conjunto.exibirPalavrasUnicas();

        System.out.println("\nVerificar se 'Java' está presente no conjunto:");
        boolean contemJava = conjunto.verificarPalavra("Java");
        System.out.println(contemJava);

        System.out.println("\nRemover 'Kotlin' do conjunto:");
        conjunto.removerPalavra("Kotlin");

        System.out.println("\nPalavras no conjunto após remoção:");
        conjunto.exibirPalavrasUnicas();
    }
}