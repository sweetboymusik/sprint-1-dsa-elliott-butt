public class Main {
    public static void main(String[] args) {
        TaskList taskList = new TaskList();

        System.out.println(taskList.getTasksTotal());
        taskList.addTask("Pick up mail");
        System.out.println(taskList.getTasksTotal());
        taskList.addTask("Get groceries");
        System.out.println(taskList.getTasksTotal());
        taskList.addTask("Call mom");
        System.out.println(taskList.getTasksTotal());

        taskList.completeTask(2);

        taskList.printTasks();
    }
}
