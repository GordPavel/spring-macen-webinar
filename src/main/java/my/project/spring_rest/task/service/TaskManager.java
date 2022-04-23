package my.project.spring_rest.task.service;

import java.util.List;
import java.util.Optional;

public interface TaskManager {
    List<Task> getAllTasks();
    Optional<Task> findTaskById(String id);
    void saveTask(Task task);
}
