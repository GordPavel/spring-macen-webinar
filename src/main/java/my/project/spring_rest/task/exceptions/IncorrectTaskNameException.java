package my.project.spring_rest.task.exceptions;

public class IncorrectTaskNameException extends IllegalTaskArgumentException{
    public IncorrectTaskNameException() {
        super("Incorrect task name");
    }
}
