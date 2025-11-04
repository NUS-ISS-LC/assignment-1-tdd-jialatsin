package sg.edu.nus.iss.epat.tdd.workshop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ToDoListTest  {
    // Define Test Fixtures
    private Task task1;
    private Task task2;
    private ToDoList taskList;

    public ToDoListTest() {
        super();
    }

    @Before
    public void setUp() throws Exception {
        // Initialise Test Fixtures
        task1 = new Task("TASK1", false);
        task2 = new Task("TASK2", false);
        taskList = new ToDoList();
        taskList.addTask(task1);
        taskList.addTask(task2);
    }

    @After
    public void tearDown() throws Exception {
        // Uninitialise test Fixtures
        System.out.println("tear down");
        taskList = null;
        task1 = null;
        task2 = null;
    }

    @Test
    public void testAddTask() {
        Task newTask = new Task("TASK3", false);
        taskList.addTask(newTask);
        assertEquals(newTask, taskList.getTask("TASK3"));

    }

    @Test
    public void testGetStatus() {
        assertFalse(taskList.getStatus("TASK1"));
        taskList.completeTask("TASK1");
        assertTrue(taskList.getStatus("TASK1"));
    }

    @Test
    public void testRemoveTask() {
        Task taskRemoved = taskList.removeTask("TASK2");
        assertEquals(task2, taskRemoved);
        assertNull(taskList.getTask("TASK2"));
    }

    @Test
    public void testGetCompletedTasks() {
        taskList.completeTask("TASK1");
        assertEquals(taskList.getCompletedTasks().size(), 1);
        assertTrue(taskList.getCompletedTasks().contains(task1));
    }
}