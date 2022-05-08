package my.project.spring_rest.task.service;

public class Task {
    String id;
    String name;
    String description;

    public Task(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
