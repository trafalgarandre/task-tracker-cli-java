import java.time.LocalDateTime;
import java.util.Scanner;

public class Task {

    private final int id;
    private String description;
    private TaskStatus status;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Task(int id, String description) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be blank.");
        }
        this.description = description;
        this.id = id;
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
        status = TaskStatus.TODO;
    }

    @Override
    public String toString() {
        return "Task " + id + ": " + description;
    }

    public static int getIdFromString(String taskString) {
        Scanner s = new Scanner(taskString);
        int id = s.useDelimiter("\\D+").nextInt();
        return id;
    }
}
