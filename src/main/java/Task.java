public class Task {
    // instance variables
    private String description;
    private boolean done;
    private Task nextTask;

    // constructor
    public Task() {
        this.description = "";
        this.done = false;
        this.nextTask = null;
    }

    public Task(String description) {
        this.description = description;
        this.done = false;
        this.nextTask = null;
    }

    // getters and setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Task getNextTask() {
        return nextTask;
    }

    public void setNextTask(Task nextTask) {
        this.nextTask = nextTask;
    }
}
