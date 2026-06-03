package repository;

import exception.TaskNotFoundException;
import model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    private final List<Task> tasks = new ArrayList<>();

    public void adicionarTask(Task task) {
        tasks.add(task);
    }

    public Task procurarTask(String nome) throws TaskNotFoundException {
        return tasks.stream()
                .filter(task -> task.getTitulo().equalsIgnoreCase(nome))
                .findFirst()
                .orElseThrow(TaskNotFoundException::new);
    }

    public void removerTask(Task task) {
        tasks.remove(task);
    }

    public void concluirTask(String nomeTask)
            throws TaskNotFoundException {

        Task task = procurarTask(nomeTask);

        task.setConcluida(true);

        System.out.println(task.isConcluida());
    }
    public void listarTasks() {
        tasks.forEach(System.out::println);
    }

    public void listarTasksConcluidas() {
        tasks.stream()
                .filter(Task::isConcluida)
                .forEach(System.out::println);
    }

    public void listarTasksNaoConcluidas() {
        tasks.stream()
                .filter(task -> !task.isConcluida())
                .forEach(System.out::println);
    }
}