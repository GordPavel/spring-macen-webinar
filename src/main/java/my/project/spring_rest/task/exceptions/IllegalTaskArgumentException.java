package my.project.spring_rest.task.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IllegalTaskArgumentException extends RuntimeException {
    public IllegalTaskArgumentException(String message) {
        super(message);
    }
}
