import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class TaskServiceTest {
    private TaskService taskService;

    @BeforeEach
    public void setUp() {
        taskService = new TaskService();
        taskService.addTask(new Task("1", "Task One", "Description for Task One"));
        taskService.addTask(new Task("2", "Task Two", "Description for Task Two"));
    }

    @Test
    public void testAddTask() {
        Task newTask = new Task("3", "Task Three", "Description for Task Three");
        taskService.addTask(newTask);
        assertEquals(newTask, taskService.getTask("3"));
    }

    @Test
    public void testDeleteTask() {
        taskService.deleteTask("1");
        assertNull(taskService.getTask("1"));
    }

    @Test
    public void testUpdateTask() {
        Task updatedTask = new Task("2", "Updated Task Two", "Updated description for Task Two");
        taskService.updateTask(updatedTask);
        assertEquals(updatedTask.getName(), taskService.getTask("2").getName());
        assertEquals(updatedTask.getDescription(), taskService.getTask("2").getDescription());
    }

    @Test
    public void testGetTask() {
        Task task = taskService.getTask("1");
        assertEquals("Task One", task.getName());
    }

    @Test
    public void testGetAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        assertEquals(2, tasks.size());
    }

    @Test
    public void testDeleteNonExistentTask() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            taskService.deleteTask("3");
        });
        assertEquals("Task ID not found", exception.getMessage());
    }

    @Test
    public void testUpdateNonExistentTask() {
        Task nonExistentTask = new Task("3", "Non-Existent Task", "Description");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTask(nonExistentTask);
        });
        assertEquals("Task ID not found", exception.getMessage());
    }
}
