package my.project.spring_rest;

import my.project.spring_rest.task.service.TaskManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class RestTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    TaskManager taskManager;

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        final Object o = this.restTemplate.postForObject("http://localhost:" + port + "/tasks/task", String.class, null);
        taskManager.getAllTasks();
    }

}
