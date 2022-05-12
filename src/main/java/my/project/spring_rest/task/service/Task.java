package my.project.spring_rest.task.service;

import lombok.Value;

@Value
public class Task {
    String id;
    String name;
    String description;
}
