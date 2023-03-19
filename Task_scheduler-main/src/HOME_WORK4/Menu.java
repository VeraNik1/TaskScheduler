package HOME_WORK4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        TaskManager<Task> taskManager = new TaskManager<>(new CurrentTaskStorage(),
                new CsvTaskExporter(), new CsvTaskImporter());

        boolean exit = false;

        while (!exit) {
            // выводим список операций
            System.out.println("1. Add a new task");
            System.out.println("2. Change the task");
            System.out.println("3. Find the task");
            System.out.println("4. Delete the task");
            System.out.println("5. View all tasks");
            System.out.println("6. Export tasks");
            System.out.println("7. Import tasks");
            System.out.println("0. Tap for exit");
            System.out.println();

            // reading of the user's input
            String choice = scanner.next();
            scanner.nextLine(); // reading \n symbol
            int taskId;
            String fail;


            switch (choice) {
                case "1":
                    try {
                        System.out.print("\nPlease, enter the start date and time for the task in the format: \"dd.MM.yyyy HH:mm\" : ");
                        LocalDateTime startDateTime = LocalDateTime.parse(scanner.nextLine(), DATE_FORMATTER);
                        System.out.print("\"Please, enter the end date and time for the task in the format: \"dd.MM.yyyy HH:mm\" : ");
                        LocalDateTime deadlineDateTime = LocalDateTime.parse(scanner.nextLine(), DATE_FORMATTER);
                        System.out.print("Please, enter priority of the task (LOW, MEDIUM, HIGH): ");
                        Priority priority = Priority.valueOf(scanner.nextLine().toUpperCase());
                        System.out.print("\n" +
                                "Enter the name of the task author: ");
                        String authorName = scanner.nextLine();
                        System.out.print("\n" +
                                "Enter the position of the task author: ");
                        String authorPosition = scanner.nextLine();
                        System.out.print("\n" +
                                "Enter the name of the controller: ");
                        Employee author = new Employee(authorName, authorPosition);
                        String controllerName = scanner.nextLine();
                        System.out.print("\n" +
                                "Enter the position of the task author: ");
                        String controllerPosition = scanner.nextLine();
                        Employee controller = new Employee(controllerName, controllerPosition);
                        System.out.print("\n" +
                                "Enter a task description: ");
                        String description = scanner.nextLine();
                        LocalDateTime timeOfCreation = LocalDateTime.now();
                        taskManager.addTask(startDateTime, deadlineDateTime, priority,
                                author, controller, description, timeOfCreation);
                    } catch (DateTimeParseException e) {
                        System.out.println("Incorrect input of date or time. Please, try again.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Incorrect input of priority. Please, try again.");
                    }
                    break;
                case "2":
                    try {
                        System.out.print("\n" +
                                "Enter the ID of the task you want to change: ");
                        taskId = scanner.nextInt();
                        scanner.nextLine(); // reading \n symbol
                        Task taskToEdit = taskManager.getTaskById(taskId);
                        if (taskToEdit == null) {
                            System.out.printf("Sorry, the task with id = %s is not found.\n", taskId);
                        } else {
                            System.out.print("Input a new task description: ");
                            String newDescription = scanner.nextLine();
                            taskToEdit.setDescription(newDescription);
                            System.out.println("The description's successfully changed");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Incorrect input. Please, try again.");
                        scanner.next();
                    }
                    break;
                case "3":
                    Search.taskSearch(taskManager);
                    break;
                case "4":
                    try {
                        System.out.println("Enter the ID of the task you want to delete: ");
                        taskId = scanner.nextInt();
                        scanner.nextLine(); // reading \n symbol
                        if (taskManager.getTaskById(taskId) == null) {
                            System.out.printf("Sorry, the task with id = %s is not found.\n", taskId);
                        } else {
                            System.out.println("Press 1 to delete the task :" + taskManager.getTaskById(taskId));
                            if (scanner.nextInt() == 1) {
                                taskManager.removeTask(taskId);
                                System.out.println("The task's successfully deleted.");
                            }
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Incorrect input. Please, try again.");
                        scanner.next();
                    }
                    break;
                case "5":
                    try {
                        List<Task> tasks = taskManager.getAllTasks();
                        if (tasks.isEmpty()) {
                            System.out.println("Task list is empty.");
                        } else {
                            for (Task task : tasks) {
                                System.out.println(task);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Error of task list loading: " + e.getMessage());
                    }
                    break;
                case "6":
                    ExportChoice.exportTo(taskManager);
                    break;
                case "7":
                    try {
                        System.out.println("Please, enter the directory and the file's name for import");
                        String file = scanner.next();
                        taskManager = taskManager.importTasks(file);
                        System.out.println("Tasks have been imported successfully");

                    } catch (Exception e) {
                        System.out.println("Error of task list import: " + e.getMessage());
                    }
                    break;
                case "0":
                    exit = true;
                    break;
                default:
                    System.out.println("Incorrect input. Please, try again.");
                    break;
            }
        }
        scanner.close();
    }
}
