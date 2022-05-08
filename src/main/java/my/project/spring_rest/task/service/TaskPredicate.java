package my.project.spring_rest.task.service;

import java.util.function.Predicate;

public interface TaskPredicate extends Predicate<Task> {
    RuntimeException errorObject();
}
