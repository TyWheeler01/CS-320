import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class TaskService {

    // In-memory data structure to store tasks
    private final Map<String, Task> tasks = new HashMap<>();

    // Add a new task
    public void addTask(Task task) {
        if (task == null || tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task ID already exists");
        }
        tasks.put(task.getTaskId(), task);
    }

    // Delete a task by taskId
    public void deleteTask(String taskId) {
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID not found");
        }
        tasks.remove(taskId);
    }

    // Update a task (name and description)
    public void updateTask(Task task) {
        if (task == null || !tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task ID not found");
        }
        tasks.put(task.getTaskId(), task); // Update the task in the map
    }

    // Get task by taskId
    public Task getTask(String taskId) {
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID not found");
        }
        return tasks.get(taskId);
    }

    // Get all tasks
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values()); // Return a list of all tasks
    }
}
