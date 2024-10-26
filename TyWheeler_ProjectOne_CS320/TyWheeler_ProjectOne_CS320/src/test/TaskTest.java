import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    private Task task;

    @BeforeEach
    public void setUp() {
        task = new Task("1", "Test Task", "This is a test task description.");
    }

    @Test
    public void testGetTaskId() {
        assertEquals("1", task.getTaskId());
    }

    @Test
    public void testGetName() {
        assertEquals("Test Task", task.getName());
    }

    @Test
    public void testGetDescription() {
        assertEquals("This is a test task description.", task.getDescription());
    }

    @Test
    public void testSetName() {
        task.setName("Updated Task");
        assertEquals("Updated Task", task.getName());
    }

    @Test
    public void testSetDescription() {
        task.setDescription("Updated task description.");
        assertEquals("Updated task description.", task.getDescription());
    }
}
