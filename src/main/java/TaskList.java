public class TaskList {
    // instance variables
    private Task head;
    private Task tail;
    private int size;

    // constructor
    public TaskList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // getters
    public Task getHead() {
        return head;
    }

    public Task getTail() {
        return tail;
    }

    public int getSize() {
        return size;
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
        size++;
    }

    public void printTasks(){
        Task current = head;

        // if the list is empty
        if (current == null){
            System.out.println("There is no tasks in the list");
            return;
        }

        // print until there is no next task
        while (current != null){
            System.out.println(current.getDescription() + (current.isCompleted() ? " completed" : " not completed"));
            current = current.getNextTask();
        }
    }
}
