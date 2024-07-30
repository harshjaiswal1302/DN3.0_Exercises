package TaskManagementSystem;
import java.util.Scanner;

public class TaskManagement {
    private Task head;

    public TaskManagement() {
        this.head = null;
    }

    public void addTask(Task newTask) {
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newTask);
        }
        System.out.println("Task added successfully.");
    }

    public Task searchTask(String taskId) {
        Task current = head;
        while (current != null) {
            if (current.getTaskId().equals(taskId)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public void traverseTasks() {
        Task current = head;
        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
    }

    public void deleteTask(String taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        if (head.getTaskId().equals(taskId)) {
            head = head.getNext();
            System.out.println("Task deleted successfully.");
            return;
        }

        Task current = head;
        Task previous = null;

        while (current != null && !current.getTaskId().equals(taskId)) {
            previous = current;
            current = current.getNext();
        }

        if (current == null) {
            System.out.println("Task not found.");
            return;
        }

        previous.setNext(current.getNext());
        System.out.println("Task deleted successfully.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManagement tm = new TaskManagement();

        while (true) {
            System.out.println("Choose an option: add, search, traverse, delete, exit");
            String option = scanner.nextLine();
            switch (option.toLowerCase()) {
                case "add":
                    System.out.println("Enter task ID:");
                    String id = scanner.nextLine();
                    System.out.println("Enter task name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter task status:");
                    String status = scanner.nextLine();
                    Task task = new Task(id, name, status);
                    tm.addTask(task);
                    break;
                case "search":
                    System.out.println("Enter task ID to search:");
                    String searchId = scanner.nextLine();
                    Task found = tm.searchTask(searchId);
                    if (found != null) {
                        System.out.println("Task found: " + found);
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;
                case "traverse":
                    System.out.println("Traversing all tasks:");
                    tm.traverseTasks();
                    break;
                case "delete":
                    System.out.println("Enter task ID to delete:");
                    String deleteId = scanner.nextLine();
                    tm.deleteTask(deleteId);
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
