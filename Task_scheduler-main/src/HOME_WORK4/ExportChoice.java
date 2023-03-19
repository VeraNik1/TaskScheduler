package HOME_WORK4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ExportChoice {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    static void exportTo(TaskManager<Task> taskManager) {
        System.out.println("Export to\n1. CSV\n2. JSON\n3. XML");
        Scanner scanner = new Scanner(System.in);
        String exportChoice = scanner.next();
        scanner.nextLine();
        switch (exportChoice) {
            case "1":
                try {
                    System.out.println("Please, enter the directory and/or the file's name for export");
                    String file = scanner.next() + ".csv";
                    taskManager.exportTasks(file);
                    System.out.println("Tasks have been exported successfully");
                } catch (Exception e) {
                    System.out.println("Error of task list export: " + e.getMessage());
                }
                break;
            case "2":
                try {
                    System.out.println("Please, enter the directory and/or the file's name for export");
                    String file = scanner.next() + ".json";
                    taskManager.setTaskExporter(new JsonTaskExporter());
                    taskManager.exportTasks(file);
                    System.out.println("Tasks have been exported successfully");
                } catch (Exception e) {
                    System.out.println("Error of task list export: " + e.getMessage());
                }
                break;
            case "3":
                try {
                    System.out.println("Please, enter the directory and/or the file's name for export");
                    String file = scanner.next() + ".xml";
                    taskManager.setTaskExporter(new XmlTaskExporter());
                    taskManager.exportTasks(file);
                    System.out.println("Tasks have been exported successfully");
                } catch (Exception e) {
                    System.out.println("Error of task list export: " + e.getMessage());
                }
                break;
            default:
                System.out.println("Incorrect button choice.");
                break;
        }
    }
}