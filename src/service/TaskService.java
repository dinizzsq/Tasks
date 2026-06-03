package service;

import exception.TaskNotFoundException;
import model.Task;
import repository.TaskRepository;

public class TaskService {

    private final TaskRepository taskRepository = new TaskRepository();

    public void criarTask(Task task) {
        taskRepository.adicionarTask(task);
    }

    public void deletarTask(String nomeTask) throws TaskNotFoundException {
        Task task = taskRepository.procurarTask(nomeTask);
        taskRepository.removerTask(task);
    }

    public void editarTask(String nomeTask, String novoNome)
            throws TaskNotFoundException {

        Task task = taskRepository.procurarTask(nomeTask);
        task.setTitulo(novoNome);
    }

    public void concluirTask(String nomeTask)
            throws TaskNotFoundException {

        taskRepository.concluirTask(nomeTask);
    }

    public void listarTasks() {
        taskRepository.listarTasks();
    }

    public void listarTasksConcluidas() {
        taskRepository.listarTasksConcluidas();
    }

    public void listarTasksNaoConcluidas() {
        taskRepository.listarTasksNaoConcluidas();
    }
}