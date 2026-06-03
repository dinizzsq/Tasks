package ui;

import exception.TaskNotFoundException;
import model.Task;
import service.TaskService;

import java.util.Scanner;

public class Menu {

    private final Scanner sc = new Scanner(System.in);
    private final TaskService taskService = new TaskService();

    public void iniciar() {

        while (true) {

            System.out.println("\n========== GERENCIADOR DE TASKS ==========");
            System.out.println("1 - Criar Task");
            System.out.println("2 - Excluir Task");
            System.out.println("3 - Editar Task");
            System.out.println("4 - Concluir Task");
            System.out.println("5 - Listar Tasks");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");

            try {

                int opcao = Integer.parseInt(sc.nextLine());

                switch (opcao) {

                    case 1:
                        criarTask();
                        break;

                    case 2:
                        excluirTask();
                        break;

                    case 3:
                        editarTask();
                        break;

                    case 4:
                        concluirTask();
                        break;

                    case 5:
                        listarTasks();
                        break;

                    case 6:
                        System.out.println("Programa encerrado.");
                        return;

                    default:
                        System.out.println("Opção inválida!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números.");
            }
        }
    }

    private void criarTask() {

        System.out.print("Quantas tasks deseja criar? ");
        int quantidade = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < quantidade; i++) {

            System.out.print("Título: ");
            String titulo = sc.nextLine();

            System.out.print("Descrição: ");
            String descricao = sc.nextLine();

            taskService.criarTask(new Task(titulo, descricao));
        }

        System.out.println("Task(s) criada(s) com sucesso!");
    }

    private void excluirTask() {

        System.out.print("Digite o nome da task: ");
        String nome = sc.nextLine();

        try {
            taskService.deletarTask(nome);
            System.out.println("Task removida com sucesso!");
        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void editarTask() {

        System.out.print("Nome da task atual: ");
        String nomeAtual = sc.nextLine();

        System.out.print("Novo nome: ");
        String novoNome = sc.nextLine();

        try {
            taskService.editarTask(nomeAtual, novoNome);
            System.out.println("Task editada com sucesso!");
        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void concluirTask() {

        System.out.print("Nome da task que deseja concluir: ");
        String nome = sc.nextLine();

        try {
            taskService.concluirTask(nome);
            System.out.println("Task concluída!");
        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void listarTasks() {

        System.out.println("\n===== TASKS =====");

        taskService.listarTasks();

        System.out.println("\n===== CONCLUÍDAS =====");

        taskService.listarTasksConcluidas();

        System.out.println("\n===== NÃO CONCLUÍDAS =====");

        taskService.listarTasksNaoConcluidas();
    }
}