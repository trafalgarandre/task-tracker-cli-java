
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class TaskRepository {
	private final Path FILE_PATH = Path.of("tasks.txt");
	
	public TaskRepository() {

	}

	public boolean addTaskToFile(Task task) {
		try {
			Files.write(FILE_PATH, (task.toString() + System.lineSeparator()).getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		} catch (IOException ex) {
			System.out.println("Exception: " + ex.getMessage());
			return false;
		}
		return true;
	}

	public int getLastTaskId() {
		if (!Files.exists(FILE_PATH)) {
			return 0;
		} else {
			try {
				List<String> lines = Files.readAllLines(FILE_PATH);
				if (lines.isEmpty()) {
					return 0;
				}
				return Task.getIdFromString(lines.get(lines.size() - 1));
			} catch (IOException ex) {
				System.out.println("Exception: " + ex.getMessage());
			}
			return -1;
		}
	}
}
