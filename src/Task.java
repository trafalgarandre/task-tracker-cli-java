import java.time.LocalDateTime;

public class Task {

    private static int idCounter = 1;
    private final int id;
    private String description;
    private TaskStatus status;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Task(String description) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be blank.");
        }
        this.description = description;
        id = Task.idCounter++;
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
        status = TaskStatus.TODO;
    }

    @Override
    public String toString() {
        return "Task " + id + ": " + description;
    }
}
