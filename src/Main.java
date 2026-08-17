public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Give command");
            return;
        }

        String command = args[0];
        switch (command) {
            case "add" -> handleAddCommand(args);
            default -> System.out.println("Unknown command");
        }
    }

    private static void handleAddCommand(String[] args) {
        if (args.length <= 1) {
            System.err.println("Missing argument");
            return;
        }
        TaskRepository taskRepository = new TaskRepository();
        int lastId = taskRepository.getLastTaskId();
        if (lastId == -1) {
            System.out.println("Error getting last Id");
            return;
        }
        Task task = new Task(lastId + 1, args[1]);
        boolean result = taskRepository.addTaskToFile(task);
        if (result) {
            System.out.println("Task added successfully - " + task.toString());
        } else {
            System.out.println("Error while adding");
        }
    }
}
