package my.project.spring_rest.task.rest.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(NOT_FOUND)
public class TaskNotFoundException extends IllegalArgumentException {
    public TaskNotFoundException(String taskId) {
        super(format("Task %s not found", taskId));
    }
}
