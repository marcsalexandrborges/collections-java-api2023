package map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {

    private Map<String, String> mapaDePalavras;

    public Dicionario() {
        mapaDePalavras = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao) {
        mapaDePalavras.put(palavra, definicao);
    }

    public void removerPalavra(String palavra) {
        mapaDePalavras.remove(palavra);
    }

    public void exibirPalavras() {
        for (Map.Entry<String, String> entry : mapaDePalavras.entrySet()) {
            String palavra = entry.getKey();
            String definicao = entry.getValue();
            System.out.println(palavra + ": " + definicao);
        }
    }

    public String pesquisarPorPalavra(String palavra) {
        return mapaDePalavras.get(palavra);
    }

    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();
        dicionario.adicionarPalavra("Cachorro", "Um animal de estimação.");
        dicionario.adicionarPalavra("Computador", "Uma máquina que processa informações.");
        dicionario.adicionarPalavra("Montanha", "Uma elevação natural da Terra.");

        System.out.println("Exibindo palavras e suas definições:");
        dicionario.exibirPalavras();

        String pesquisa = "Cachorro";
        System.out.println("\nDefinição de '" + pesquisa + "': " + dicionario.pesquisarPorPalavra(pesquisa));

        pesquisa = "Gato"; // Uma palavra que não está no dicionário.
        System.out.println("\nDefinição de '" + pesquisa + "': " + dicionario.pesquisarPorPalavra(pesquisa));

        System.out.println("\nRemovendo 'Computador' do dicionário.");
        dicionario.removerPalavra("Computador");

        System.out.println("\nExibindo palavras após a remoção:");
        dicionario.exibirPalavras();
    }
}
