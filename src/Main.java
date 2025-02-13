import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        boolean isZero = false;
        while (!isZero) {
            System.out.println("""
            Please choose an option:
            (1) Add a task.
            (2) Remove a task.
            (3) Update a task.
            (4) List all tasks.
            (5) List tasks at specified priority.
            (0) Exit.
            """);
            String request = input.nextLine();
            switch(request) {
                case "0":
                    isZero = true;
                    break;
                case "1":
                    addTask(tasks);
                    break;
                case "2":
                    removeTask(tasks);
                    break;
                case "3":
                    updateTask(tasks);
                    break;
                case "4":
                    listTasks(tasks);
                    break;
                case "5":
                    listPriority(tasks);
                    break;
                default:
                    System.out.println("Invalid option! Enter a number 0-5");
                    break;
            }
            System.out.println("Done!");
        }
    }
    static void addTask(ArrayList<Task> tasks) {
        System.out.println("What task would you like to add?");
        String name = input.nextLine();
        System.out.println("What is the description for this task?");
        String desc = input.nextLine();
        int prior = -1;
        while (prior < 0 | prior > 5) {
            System.out.println("What is the priority of this task? (1-5)");
            prior = input.nextInt();
            input.nextLine();
        }
        tasks.add(new Task(name, desc, prior));
    }
    static void removeTask(ArrayList<Task> tasks) {
        if (!tasks.isEmpty()) {
            int toRemove = -1;
            while (toRemove < 0 | toRemove > tasks.size() - 1) {
                System.out.println("What is the index of the task to remove?");
                toRemove = input.nextInt();
                input.nextLine();
            }
            tasks.remove(toRemove);
        } else {
            System.out.println("You have no tasks to remove!");
        }
    }
    static void updateTask(ArrayList<Task> tasks) {
        if (!tasks.isEmpty()) {
            int index = -1;
            while (index < 0 | index > tasks.size() - 1) {
                System.out.println("What is the index of the task to change?");
                index = input.nextInt();
                input.nextLine();
            }
            System.out.println("What task would you like to add?");
            String name = input.nextLine();
            System.out.println("What is the description for this task?");
            String desc = input.nextLine();
            int prior = -1;
            while (prior < 0 | prior > 5) {
                System.out.println("What is the priority of this task? (1-5)");
                prior = input.nextInt();
                input.nextLine();
            }
            tasks.set(index, new Task(name, desc, prior));
        } else {
            System.out.println("You have no tasks to update!");
        }
    }

    static void listTasks(ArrayList<Task> tasks) {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + ". " + tasks.get(i));
        }
    }
    static void listPriority(ArrayList<Task> tasks) {
        System.out.println("What priority do you want to list?");
        int prior = input.nextInt();
        input.nextLine();
        for (Task task : tasks) {
            if (task.getPriority() == prior) {
                System.out.println(task);
            }
        }
    }
    static class Task {
        private String name;
        private String desc;
        private int prior;

        public Task(String name, String desc, int prior) {
            this.name = name;
            this.desc = desc;
            this.prior = prior;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getPriority() {
            return prior;
        }

        public void setPriority(int priority) {
            this.prior = priority;
        }

        @Override
        public String toString() {
            return  "\nTask" +
                    "\nname: " + name +
                    "\ndesc: " + desc +
                    "\npriority: " + prior;
        }
    }
}