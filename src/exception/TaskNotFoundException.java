package exception;

public class TaskNotFoundException extends Exception{

    public TaskNotFoundException(){
        super("Essa task não existe!");
    }
}
