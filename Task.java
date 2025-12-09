public class Task {
    int id;
    String title;
    boolean isCompleted;

    Task(int id, String title) {
        this.id = id;
        this.title = title;
        this.isCompleted = false;
    }

    public void markDone() {
        isCompleted = true;
    }

    public String toString() {
        return "ID: " + id + " | " + title + " | Status: " + (isCompleted ? "Done" : "Pending");
    }
}
