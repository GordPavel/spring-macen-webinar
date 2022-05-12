package my.project.spring_rest.task.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SimpleTaskManager implements TaskManager {
    private final Map<String, Task> tasksStorage;

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
        tasksStorage.put(task.getId(), task);
    }
}
