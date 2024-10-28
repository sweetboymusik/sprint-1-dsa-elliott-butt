import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // array of users
        User[] users = new User[10];

        // mock user data
        TaskList taskList1 = new TaskList();
        taskList1.addTask("Get art supplies");
        taskList1.completeTask("Get art supplies");
        taskList1.addTask("Paint a happy little tree");
        User user1 = new User("Bob", taskList1);

        TaskList taskList2 = new TaskList();
        taskList2.addTask("Complete DSA sprint");
        taskList2.completeTask("Complete DSA sprint");
        taskList2.addTask("Complete part 1 of other sprint assignment");
        taskList2.addTask("Complete part 2 of other sprint assignment");
        User user2 = new User("Elliott", taskList2);

        TaskList taskList3 = new TaskList();
        taskList3.addTask("Take out the trash");
        taskList3.addTask("Walk the dog");
        taskList3.addTask("Cook supper");
        taskList3.completeTask("Cook supper");
        taskList3.addTask("Get ready for tomorrow");
        User user3 = new User("Joe", taskList3);

        users[0] = user1;
        users[1] = user2;
        users[2] = user3;

        // main menu
        while (true) {
            System.out.println();
            System.out.println("Todo List Application");
            System.out.println("1. Select User");
            System.out.println("2. Add User");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid choice");
                scanner.nextLine();
                continue;
            }

            scanner.nextLine();

            switch (choice) {
                case 1:
                    selectUser(users);
                    break;
                case 2:
                    addUser(users);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    return;
                default:
                    break;
            }
        }
    }

    private static void selectUser(User[] users) {
        User selectedUser = null;

        System.out.println();
        System.out.println("Select a user:");

        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                System.out.println((i + 1) + ". " + users[i].getUsername());
            }
        }

        System.out.print("Enter the name: ");

        String choice = scanner.nextLine();

        for (User user : users) {
            if (user != null && user.getUsername().equals(choice)) {
                selectedUser = user;
            }
        }

        if (selectedUser != null) {
            System.out.println("Logging in as " + selectedUser.getUsername());
            userMenu(selectedUser);
        } else {
            System.out.println("User not found");
        }
    }

    private static void userMenu(User user) {
        while (true) {
            String completedTasks = user.getTaskList().getTasksCompleted() + "/" + user.getTaskList().getTasksTotal();

            System.out.println();
            System.out.println("Todo List - " + user.getUsername() + " (" + completedTasks + ")");
            user.getTaskList().printTasks();

            System.out.print("Enter 'add' to add a task, 'done' to complete a task, or 'quit' to exit: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "add":
                    addTask(user);
                    break;
                case "done":
                    completeTask(user);
                    break;
                case "quit":
                    return;
                default:
                    break;
            }
        }
    }

    private static void addTask(User user) {
        System.out.println();
        System.out.println("Adding Task:");
        System.out.print("Enter task description: ");

        String description = scanner.nextLine();
        user.getTaskList().addTask(description);
    }

    private static void completeTask(User user) {
        System.out.println();
        System.out.println("Completing Task:");
        System.out.print("Enter task description to mark as complete: ");

        String description = scanner.nextLine();
        user.getTaskList().completeTask(description);
    }

    private static void addUser(User[] users) {
        System.out.println();
        System.out.println("Adding User:");
        System.out.print("Enter new username: ");

        String newUsername = scanner.nextLine();

        int indexToInsert = -1;

        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                indexToInsert = i;
                break;
            }
        }

        if (indexToInsert == -1) {
            System.out.println("Cannot add any more users!");
            return;
        }

        users[indexToInsert] = new User(newUsername);
        System.out.println("New user added successfully!");
    }

}
