package HOME_WORK4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
public class Search {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    static void taskSearch(TaskManager taskManager) {
        System.out.println("Task search\n1. By Id\n2. from Now to Deadline\n3. Tasks have to be done after picked date\n4. By priority");
        Scanner scanner = new Scanner(System.in);
        int taskId;
        int searchChoice = scanner.nextInt();
        scanner.nextLine();

        switch (searchChoice) {
            case 1:
                System.out.print("Input task ID: ");
                taskId = scanner.nextInt();
                scanner.nextLine();
                Task taskById = taskManager.getTaskById(taskId);
                if (taskById == null) {
                    System.out.printf("Sorry, the task with id = %s is not found.\n", taskId);
                } else {
                    System.out.println(taskById);
                }
                break;
            case 2:
                System.out.print("Enter Deadline date and time in the format\"dd.MM.yyyy HH:mm\": ");
                LocalDateTime deadlineForTasksBefore = LocalDateTime.parse(scanner.nextLine(), DATE_FORMATTER);
                List<Task> tasksBeforeDeadline = taskManager.getTasksBetween(LocalDateTime.now(),deadlineForTasksBefore);
                if (tasksBeforeDeadline.isEmpty()) {
                    System.out.println("Tasks haven't been found");
                } else {
                    for (Task task : tasksBeforeDeadline) {
                        System.out.println(task);
                    }
                }
                break;
            case 3:
                System.out.print("Enter the date and time to see tasks, which have to be done after picked date\"dd.MM.yyyy HH:mm\": ");
                LocalDateTime searchDateTime = LocalDateTime.parse(scanner.nextLine(), DATE_FORMATTER);
                List<Task> tasksAfterDateTime = taskManager.getTasksAfter(searchDateTime);
                if (tasksAfterDateTime.isEmpty()) {
                    System.out.println("Tasks haven't been found");
                } else {
                    for (Task task : tasksAfterDateTime) {
                        System.out.println(task);
                    }
                }
                break;
            case 4:
                System.out.print("Please, enter priority (LOW, MEDIUM, HIGH): ");
                Priority priority = Priority.valueOf(scanner.nextLine().toUpperCase());
                List<Task> tasksByPriority = taskManager.getTasksByPriority(priority);
                if (tasksByPriority.isEmpty()) {
                    System.out.println("Tasks haven't been found");
                } else {
                    for (Task task : tasksByPriority) {
                        System.out.println(task);
                    }
                }
                break;
            default:
                System.out.println("Incorrect button choice.");
                break;
        }
    }
}