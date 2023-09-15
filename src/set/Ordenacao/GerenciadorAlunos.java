package set.Ordenacao;

import java.util.*;

public class GerenciadorAlunos {

    private Set<Aluno> conjuntoDeAlunos;

    public GerenciadorAlunos() {
        conjuntoDeAlunos = new HashSet<>();
    }

    public void adicionarAluno(String nome, long matricula, double media) {
        Aluno aluno = new Aluno(nome, matricula, media);
        conjuntoDeAlunos.add(aluno);
    }

    public void removerAluno(long matricula) {
        conjuntoDeAlunos.removeIf(aluno -> aluno.getMatricula() == matricula);
    }

    public void exibirAlunosPorNome() {
        List<Aluno> listaOrdenada = new ArrayList<>(conjuntoDeAlunos);
        Collections.sort(listaOrdenada, Comparator.comparing(Aluno::getNome));
        for (Aluno aluno : listaOrdenada) {
            System.out.println(aluno);
        }
    }

    public void exibirAlunosPorNota() {
        List<Aluno> listaOrdenada = new ArrayList<>(conjuntoDeAlunos);
        Collections.sort(listaOrdenada, Comparator.comparing(Aluno::getNota));
        for (Aluno aluno : listaOrdenada) {
            System.out.println(aluno);
        }
    }

    public void exibirAlunos() {
        for (Aluno aluno : conjuntoDeAlunos) {
            System.out.println(aluno);
        }
    }

    public static void main(String[] args) {
        GerenciadorAlunos gerenciador = new GerenciadorAlunos();
        gerenciador.adicionarAluno("Alice", 1001, 8.5);
        gerenciador.adicionarAluno("Bob", 1002, 7.0);
        gerenciador.adicionarAluno("Carol", 1003, 9.2);

        System.out.println("Lista de Alunos (por nome):");
        gerenciador.exibirAlunosPorNome();

        System.out.println("\nLista de Alunos (por nota):");
        gerenciador.exibirAlunosPorNota();

        System.out.println("\nRemovendo aluno com matrícula 1002...");
        gerenciador.removerAluno(1002);

        System.out.println("\nLista de Alunos após remoção:");
        gerenciador.exibirAlunos();
    }
}
