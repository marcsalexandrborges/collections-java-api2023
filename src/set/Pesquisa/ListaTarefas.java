package set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {

    private Set<Tarefa> tarefas;

    public ListaTarefas() {
        tarefas = new HashSet<>();
    }

    public void adicionarTarefa(String descricao) {
        Tarefa novaTarefa = new Tarefa(descricao);
        tarefas.add(novaTarefa);
    }

    public void removerTarefa(String descricao) {
        Tarefa tarefaParaRemover = new Tarefa(descricao);
        tarefas.remove(tarefaParaRemover);
    }

    public void exibirTarefas() {
        for (Tarefa tarefa : tarefas) {
            System.out.println("Descrição: " + tarefa.getDescricao() + ", Concluída: " + tarefa.isConcluida());
        }
    }

    public int contarTarefas() {
        return tarefas.size();
    }

    public Set<Tarefa> obterTarefasConcluidas() {
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        for (Tarefa tarefa : tarefas) {
            if (tarefa.isConcluida()) {
                tarefasConcluidas.add(tarefa);
            }
        }
        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes() {
        Set<Tarefa> tarefasPendentes = new HashSet<>();
        for (Tarefa tarefa : tarefas) {
            if (!tarefa.isConcluida()) {
                tarefasPendentes.add(tarefa);
            }
        }
        return tarefasPendentes;
    }

    public void marcarTarefaConcluida(String descricao) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getDescricao().equals(descricao)) {
                tarefa.marcarConcluida();
                break;
            }
        }
    }

    public void marcarTarefaPendente(String descricao) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getDescricao().equals(descricao)) {
                tarefa.marcarPendente();
                break;
            }
        }
    }

    public void limparListaTarefas() {
        tarefas.clear();
    }


    public static void main(String[] args) {
        ListaTarefas lista = new ListaTarefas();

        lista.adicionarTarefa("Fazer compras");
        lista.adicionarTarefa("Estudar Java");
        lista.adicionarTarefa("Lavar o carro");

        System.out.println("Tarefas:");
        lista.exibirTarefas();

        System.out.println("\nTotal de Tarefas: " + lista.contarTarefas());

        System.out.println("\nTarefas Concluídas:");
        lista.marcarTarefaConcluida("Fazer compras");
        lista.exibirTarefas();

        System.out.println("\nTarefas Pendentes:");
        lista.marcarTarefaPendente("Fazer compras");
        lista.exibirTarefas();

        System.out.println("\nTotal de Tarefas Concluídas: " + lista.obterTarefasConcluidas().size());
        System.out.println("Total de Tarefas Pendentes: " + lista.obterTarefasPendentes().size());

        System.out.println("\nRemovendo todas as tarefas...");
        lista.limparListaTarefas();
        System.out.println("Total de Tarefas: " + lista.contarTarefas());
    }
}

