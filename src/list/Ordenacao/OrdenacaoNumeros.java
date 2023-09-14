package list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    private List<Integer> numeros;

    public OrdenacaoNumeros() {
        this.numeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        numeros.add(numero);
    }

    public void ordenarAscendente() {
        Collections.sort(numeros);
    }

    public void ordenarDescendente() {
        Collections.sort(numeros, Collections.reverseOrder());
    }

    public List<Integer> exibirNumeros() {
        return new ArrayList<>(numeros);
    }



    public static void main(String[] args) {
        OrdenacaoNumeros ordenacaoNumeros = new OrdenacaoNumeros();

        ordenacaoNumeros.adicionarNumero(10);
        ordenacaoNumeros.adicionarNumero(5);
        ordenacaoNumeros.adicionarNumero(20);
        ordenacaoNumeros.adicionarNumero(15);

        System.out.println("Números na lista: " + ordenacaoNumeros.exibirNumeros());

        ordenacaoNumeros.ordenarAscendente();
        System.out.println("Ordenados em ordem ascendente: " + ordenacaoNumeros.exibirNumeros());

        ordenacaoNumeros.ordenarDescendente();
        System.out.println("Ordenados em ordem descendente: " + ordenacaoNumeros.exibirNumeros());
    }
}

