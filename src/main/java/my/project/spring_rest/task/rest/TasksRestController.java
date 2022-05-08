package my.project.spring_rest.task.rest;

import my.project.spring_rest.task.service.Task;
import my.project.spring_rest.task.service.TaskManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
public class TasksRestController {
    @Autowired
    private TaskManager taskManager;

    @GetMapping("/task")
    public Task getTaskById(
            @RequestParam("id") String taskId
    ) {
        return taskManager.findTaskById(taskId).get();
    }

    @PostMapping("/task")
    public void saveTask(
            @RequestBody Task task
    ) {
        taskManager.saveTask(task);
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskManager.getAllTasks();
    }
}
