
package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
  private List<Item> itens;

  public CarrinhoDeCompras() {
    this.itens = new ArrayList<>();
  }

  public void adicionarItem(String nome, double preco, int quantidade) {
    Item item = new Item(nome, preco, quantidade);
    itens.add(item);
  }
  public void removerItem(String nome) {
    for (int i = 0; i < itens.size(); i++) {
      if (itens.get(i).getNome().equals(nome)) {
        itens.remove(i);
        i--; // Reduz o índice para continuar verificando a próxima posição após a remoção.
      }
    }
  }

  public double calcularValorTotal() {
    double total = 0.0;
    for (Item item : itens) {
      total += item.getPreco() * item.getQuantidade();
    }
    return total;
  }

  public void exibirItens() {
    for (Item item : itens) {
      System.out.println("Nome: " + item.getNome());
      System.out.println("Preço: " + item.getPreco());
      System.out.println("Quantidade: " + item.getQuantidade());
      System.out.println("---------------------------");
    }
  }


 // Aqui está um exemplo de como você pode usar essa classe:




  public static void main(String[] args) {
    CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

    carrinho.adicionarItem("Camiseta", 25.0, 2);
    carrinho.adicionarItem("Calça Jeans", 50.0, 1);
    carrinho.adicionarItem("Tênis", 75.0, 1);

    carrinho.exibirItens();
    System.out.println("Valor Total: " + carrinho.calcularValorTotal());

    carrinho.removerItem("Camiseta");

    carrinho.exibirItens();
    System.out.println("Valor Total: " + carrinho.calcularValorTotal());
  }
}

 // Este código cria um carrinho de compras, adiciona itens a ele, remove um item pelo nome e calcula o valor total dos itens no carrinho.


