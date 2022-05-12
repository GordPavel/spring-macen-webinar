package my.project.spring_rest.task.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class TasksStorageConfiguration {
    @Bean
    Map<String, Task> tasksStorage() {
        return new HashMap<>();
    }
}
