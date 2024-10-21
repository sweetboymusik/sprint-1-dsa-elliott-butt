public class User {
    private String username;
    private TaskList taskList;

    // constructors
    public User(String username) {
        this.username = username;
        this.taskList = new TaskList();
    }

    public User(String username, TaskList taskList) {
        this.username = username;
        this.taskList = taskList;
    }

    // getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public TaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }
}
