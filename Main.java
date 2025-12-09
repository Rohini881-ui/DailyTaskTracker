import java.util.*;

public class Main {

    static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Daily Task Tracker ---");
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Mark Task as Done");
            System.out.println("4. Delete Task");
            System.out.println("5. View Completed Tasks");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
    case 1:
        addTask(sc);
        break;
    case 2:
        viewTasks();
        break;
    case 3:
        markDone(sc);
        break;
    case 4:
        deleteTask(sc);
        break;
    case 5:
        viewCompleted();
        break;
    case 6:
        System.out.println("Exiting...");
        break;
    default:
        System.out.println("Invalid choice!");
}

        } while (choice != 6);
    }

    static void addTask(Scanner sc) {
        System.out.print("Enter Task ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Task Title: ");
        String title = sc.nextLine();

        tasks.add(new Task(id, title));
        System.out.println("Task added!");
    }

    static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }
        tasks.forEach(System.out::println);
    }

    static void markDone(Scanner sc) {
        System.out.print("Enter Task ID to mark done: ");
        int id = sc.nextInt();

        for (Task t : tasks) {
            if (t.id == id) {
                t.markDone();
                System.out.println("Task marked as completed!");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    static void deleteTask(Scanner sc) {
        System.out.print("Enter Task ID to delete: ");
        int id = sc.nextInt();

        for (Task t : tasks) {
            if (t.id == id) {
                tasks.remove(t);
                System.out.println("Task deleted!");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    static void viewCompleted() {
        boolean found = false;
        for (Task t : tasks) {
            if (t.isCompleted) {
                System.out.println(t);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No completed tasks.");
        }
    }
}

