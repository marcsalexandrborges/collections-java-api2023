package map.Ordenacao;

import java.util.*;

public class LivrariaOnLine {

    public static class LivrariaOnline {
        private Map<String, Livro> livros;

        public LivrariaOnline() {
            livros = new HashMap<>();
        }

        public void adicionarLivro(String link, String titulo, String autor, double preco) {
            Livro livro = new Livro(titulo, autor, preco);
            livros.put(link, livro);
        }

        public void removerLivro(String titulo) {
            List<String> linksParaRemover = new ArrayList<>();

            for (Map.Entry<String, Livro> entry : livros.entrySet()) {
                if (entry.getValue().getTitulo().equals(titulo)) {
                    linksParaRemover.add(entry.getKey());
                }
            }

            for (String link : linksParaRemover) {
                livros.remove(link);
            }
        }

        public void exibirLivrosOrdenadosPorPreco() {
            List<Livro> listaDeLivros = new ArrayList<>(livros.values());

            listaDeLivros.sort(Comparator.comparingDouble(Livro::getPreco));

            for (Livro livro : listaDeLivros) {
                System.out.println(livro);
            }
        }

        public List<Livro> pesquisarLivrosPorAutor(String autor) {
            List<Livro> livrosDoAutor = new ArrayList<>();

            for (Livro livro : livros.values()) {
                if (livro.getAutor().equals(autor)) {
                    livrosDoAutor.add(livro);
                }
            }

            return livrosDoAutor;
        }

        public Livro obterLivroMaisCaro() {
            if (livros.isEmpty()) {
                return null;
            }

            Livro livroMaisCaro = null;
            for (Livro livro : livros.values()) {
                if (livroMaisCaro == null || livro.getPreco() > livroMaisCaro.getPreco()) {
                    livroMaisCaro = livro;
                }
            }

            return livroMaisCaro;
        }

        public Livro obterLivroMaisBarato() {
            if (livros.isEmpty()) {
                return null;
            }

            Livro livroMaisBarato = null;
            for (Livro livro : livros.values()) {
                if (livroMaisBarato == null || livro.getPreco() < livroMaisBarato.getPreco()) {
                    livroMaisBarato = livro;
                }
            }

            return livroMaisBarato;
        }

        public static void main(String[] args) {
            LivrariaOnline livraria = new LivrariaOnline();
            livraria.adicionarLivro("https://www.amazon.com/livro1", "Livro 1", "Autor 1", 25.99);
            livraria.adicionarLivro("https://www.amazon.com/livro2", "Livro 2", "Autor 2", 19.99);
            livraria.adicionarLivro("https://www.amazon.com/livro3", "Livro 3", "Autor 1", 29.99);

            System.out.println("Lista de Livros (ordenados por preço):");
            livraria.exibirLivrosOrdenadosPorPreco();

            System.out.println("\nLivros escritos por 'Autor 1':");
            List<Livro> livrosAutor1 = livraria.pesquisarLivrosPorAutor("Autor 1");
            for (Livro livro : livrosAutor1) {
                System.out.println(livro);
            }

            Livro livroMaisCaro = livraria.obterLivroMaisCaro();
            if (livroMaisCaro != null) {
                System.out.println("\nLivro mais caro: " + livroMaisCaro);
            } else {
                System.out.println("\nNenhum livro na livraria.");
            }

            Livro livroMaisBarato = livraria.obterLivroMaisBarato();
            if (livroMaisBarato != null) {
                System.out.println("\nLivro mais barato: " + livroMaisBarato);
            } else {
                System.out.println("\nNenhum livro na livraria.");
            }

            System.out.println("\nRemovendo o livro 'Livro 2' da livraria.");
            livraria.removerLivro("Livro 2");

            System.out.println("\nLista de Livros após a remoção:");
            livraria.exibirLivrosOrdenadosPorPreco();
        }
    }

}