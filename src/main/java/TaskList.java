public class TaskList {
    // instance variables
    private Task head;
    private Task tail;
    private int tasksTotal;
    private int tasksCompleted;

    // constructor
    public TaskList() {
        this.head = null;
        this.tail = null;
        this.tasksTotal = 0;
        this.tasksCompleted = 0;
    }

    // getters
    public Task getHead() {
        return head;
    }

    public Task getTail() {
        return tail;
    }

    public int getTasksTotal() {
        return tasksTotal;
    }

    public int getTasksCompleted() {
        return tasksCompleted;
    }

    public void addTask(String description) {
        Task newTask = new Task(description);

        if (head == null) {
            head = newTask;
        } else {
            tail.setNextTask(newTask);
        }

        // always add task at end of list and increment size
        tail = newTask;
        tasksTotal++;
    }

    public void completeTask(int index) {
        // check if bad index
        if (index < 0 || index == tasksTotal) {
            System.out.println("Invalid index.");
            return;
        }

        Task currentTask = head;

        for (int i = 0; i < index; i++) {
            currentTask = currentTask.getNextTask();
        }

        currentTask.setCompleted(true);
        tasksCompleted++;
    }

    public void completeTask(String description) {
        Task currentTask = head;

        while (currentTask != null) {
            if (currentTask.getDescription().equals(description)) {
                currentTask.setCompleted(true);
                tasksCompleted++;
                return;
            }

            currentTask = currentTask.getNextTask();
        }
    }

    public void printTasks() {
        Task currentTask = head;

        // if the list is empty
        if (currentTask == null) {
            System.out.println("There are no tasks in the list");
            return;
        }


        System.out.println(tasksCompleted + "/" + tasksTotal);

        // print until there is no next task
        int elementNum = 1;
        while (currentTask != null) {
            System.out.println(elementNum + (currentTask.isCompleted() ? ". ✓ " : ". ○ ") + currentTask.getDescription());
            currentTask = currentTask.getNextTask();
            elementNum++;
        }
    }
}
