package sg.edu.nus.iss.epat.tdd.workshop;
import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

public class ToDoList {
   private HashMap<String, Task> tasks = new HashMap<String, Task>();

   public void addTask(Task task) {
      if (task != null && task.getDescription() != null) {
         tasks.put(task.getDescription(), task);
      }
   }

   public void completeTask(String description) {
      Task task = tasks.get(description);
      if (task != null) {
         task.setComplete(true);
      }
   }

   public boolean getStatus(String description) {
      Task task = tasks.get(description);
      return task != null && task.isComplete();
   }

   public Task getTask(String description) {
      return tasks.get(description);
   }

   public Task removeTask(String description) {
      return tasks.remove(description);
   }

   public Collection<Task> getAllTasks() {
      return tasks.values();
   }

   public Collection<Task> getCompletedTasks() {
      return tasks.values()
                  .stream()
                  .filter(Task::isComplete)
                  .collect(Collectors.toList());
   }
}
