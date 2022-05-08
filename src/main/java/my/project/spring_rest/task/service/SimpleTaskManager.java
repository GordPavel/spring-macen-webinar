package my.project.spring_rest.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;

public class SimpleTaskManager implements TaskManager {

    @Autowired
    private List<TaskPredicate> taskValidators;
    private final Map<String, Task> tasksStorage = new HashMap<>();

    @Override
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasksStorage.values());
    }

    @Override
    public Optional<Task> findTaskById(String id) {
        return Optional.ofNullable(tasksStorage.get(id));
    }

    @Override
    public void saveTask(Task task) {
        final var taskErrorValidator = taskValidators.stream()
                .filter(validator -> !validator.test(task))
                .findFirst();
        taskErrorValidator.ifPresent(validator -> {
            throw validator.errorObject();
        });
        tasksStorage.put(task.id, task);
    }
}
