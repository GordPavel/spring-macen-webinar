package my.project.spring_rest.task.service;

import my.project.spring_rest.task.exceptions.IncorrectTaskNameException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(1)
public class TaskNameValidator implements TaskPredicate {
    @Override
    public boolean test(Task task) {
        return task.getName().length() > 4;
    }


    @Override
    public RuntimeException errorObject() {
        return new IncorrectTaskNameException();
    }
}
