package my.project.spring_rest.task.service;

import my.project.spring_rest.task.exceptions.RudeWordsException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(100)
public class TaskDescriptionRudeWordsValidator implements TaskPredicate {
    @Override
    public boolean test(Task task) {
        return true;
    }

    @Override
    public RuntimeException errorObject() {
        return new RudeWordsException();
    }
}
