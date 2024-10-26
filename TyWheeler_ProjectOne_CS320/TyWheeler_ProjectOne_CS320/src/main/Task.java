public class Task {

    // Fields
    private final String taskId; // Immutable task ID
    private String name; // Task name
    private String description; // Task description

    // Constructor
    public Task(String taskId, String name, String description) {
        // Validate taskId
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Invalid task ID");
        }
        this.taskId = taskId;

        // Validate name
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid task name");
        }
        this.name = name;

        // Validate description
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid task description");
        }
        this.description = description;
    }

    // Getters
    public String getTaskId() {
        return taskId; // No setter for taskId as it is immutable
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // Setters for name and description with validation
    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid task name");
        }
        this.name = name;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid task description");
        }
        this.description = description;
    }
}
