package my.project.spring_rest.task.service;

import java.util.*;

public class SimpleTaskManager implements TaskManager {
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
        tasksStorage.put(task.id, task);
    }
}
