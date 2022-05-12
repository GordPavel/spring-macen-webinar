package my.project.spring_rest.task.rest;

import my.project.spring_rest.task.service.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class TasksRestControllerTest {

    @LocalServerPort
    int port;

    @Autowired
    Map<String, Task> tasksStorage;

    @Autowired
    TestRestTemplate restTemplate;

    String baseUrl;

    @BeforeEach
    void setUp() {
        baseUrl = String.format("http://localhost:%s/tasks", port);
        tasksStorage.clear();
    }

    @Test
    void given_EmptyStorage_when_SaveNewTask_then_TaskExistsInStorage() {
        final var taskId = "1";
        final var task = new Task(
                taskId,
                "task_1",
                "description"
        );
        this.restTemplate.postForObject(baseUrl + "/task", task, Void.class);
        assertThat(tasksStorage).containsEntry(taskId, task);
    }

    @Test
    void given_EmptyStorage_when_RequestTask_then_NotFoundStatusCode() {
        final var taskId = "1";
        final var response = this.restTemplate.getForEntity(baseUrl + "/task?id=" + taskId, Task.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void given_StorageWithTask_when_RequestTask_then_ReturnsTask() {
        final var taskId = "1";
        final var expectedTask = new Task(
                taskId,
                "task_1",
                "description"
        );
        tasksStorage.put(taskId, expectedTask);
        final var actualTask = this.restTemplate.getForObject(baseUrl + "/task?id=" + taskId, Task.class);
        assertThat(actualTask).isEqualTo(expectedTask);
    }

}