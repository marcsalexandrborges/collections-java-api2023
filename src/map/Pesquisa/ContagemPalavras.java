package map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {

    private Map<String, Integer> mapaDeContagem;

    public ContagemPalavras() {
        mapaDeContagem = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem) {
        mapaDeContagem.put(palavra, mapaDeContagem.getOrDefault(palavra, 0) + contagem);
    }

    public void removerPalavra(String palavra) {
        mapaDeContagem.remove(palavra);
    }

    public void exibirContagemPalavras() {
        for (Map.Entry<String, Integer> entry : mapaDeContagem.entrySet()) {
            String palavra = entry.getKey();
            Integer contagem = entry.getValue();
            System.out.println(palavra + ": " + contagem);
        }
    }

    public Map.Entry<String, Integer> encontrarPalavraMaisFrequente() {
        Map.Entry<String, Integer> palavraMaisFrequente = null;
        for (Map.Entry<String, Integer> entry : mapaDeContagem.entrySet()) {
            if (palavraMaisFrequente == null || entry.getValue() > palavraMaisFrequente.getValue()) {
                palavraMaisFrequente = entry;
            }
        }
        return palavraMaisFrequente;
    }

    public static void main(String[] args) {
        ContagemPalavras contagem = new ContagemPalavras();
        contagem.adicionarPalavra("gato", 3);
        contagem.adicionarPalavra("cachorro", 5);
        contagem.adicionarPalavra("gato", 2);
        contagem.adicionarPalavra("peixe", 4);

        System.out.println("Exibindo contagem de palavras:");
        contagem.exibirContagemPalavras();

        Map.Entry<String, Integer> maisFrequente = contagem.encontrarPalavraMaisFrequente();
        if (maisFrequente != null) {
            System.out.println("\nPalavra mais frequente: " + maisFrequente.getKey() + " (Aparece " + maisFrequente.getValue() + " vezes)");
        } else {
            System.out.println("\nNão há palavras no dicionário.");
        }

        System.out.println("\nRemovendo a palavra 'gato' da contagem.");
        contagem.removerPalavra("gato");

        System.out.println("\nExibindo contagem de palavras após a remoção:");
        contagem.exibirContagemPalavras();
    }
}
