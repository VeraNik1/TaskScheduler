package HOME_WORK4;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CsvTaskImporter implements TaskImporter<Task> {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public TaskManager<Task> importTasks(String filePath) {
        TaskStorage<Task> taskStorage = new CurrentTaskStorage();
        TaskExporter<Task> taskExporter = new CsvTaskExporter();
        TaskImporter<Task> taskImporter = new CsvTaskImporter();
        TaskManager<Task> taskManager = new TaskManager<>(taskStorage, taskExporter, taskImporter);
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                LocalDateTime addedDateTime = LocalDateTime.parse(parts[1], DATE_FORMATTER);
                LocalDateTime deadlineDateTime = LocalDateTime.parse(parts[2], DATE_FORMATTER);
                Priority priority = Priority.valueOf(parts[3]);
                String[] authorInfo = parts[4].split(";");;
                Employee author = new Employee(authorInfo[0],authorInfo[1]);
                String[] controllerInfo = parts[5].split(";");
                Employee controller = new Employee(controllerInfo[0],controllerInfo[1]);
                String description = parts[6];
                LocalDateTime timeOfCreation = LocalDateTime.parse(parts[7], DATE_FORMATTER);
                taskManager.addTask(addedDateTime, deadlineDateTime, priority, author, controller, description, timeOfCreation);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return taskManager;
    }
}