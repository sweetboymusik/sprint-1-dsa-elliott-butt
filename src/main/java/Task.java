public class Task {
    // instance variables
    private String description;
    private boolean completed;
    private Task nextTask;

    // constructor
    public Task() {
        this.description = "";
        this.completed = false;
        this.nextTask = null;
    }

    public Task(String description) {
        this.description = description;
        this.completed = false;
        this.nextTask = null;
    }

    // getters and setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Task getNextTask() {
        return nextTask;
    }

    public void setNextTask(Task nextTask) {
        this.nextTask = nextTask;
    }
}
