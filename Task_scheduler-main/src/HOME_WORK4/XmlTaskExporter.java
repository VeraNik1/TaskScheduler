package HOME_WORK4;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class XmlTaskExporter implements TaskExporter<Task> {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public void export(List<Task> tasks, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            writer.println("<TASKS>");
            for (Task task:
                 tasks) {
                writer.printf("<TASK>\n<ID>%s</ID>\n<START>%s</START>\n<DEADLINE>%s</DEADLINE>\n" +
                                "<PRIORITY>%s</PRIORITY>\n<AUTHOR>%s</AUTHOR>\n<CONTROLLER>%s</CONTROLLER>" +
                                "\n<DESCRIPTION>%s</DESCRIPTION>\n<CREATED>%s</CREATED>\n</TASK>\n",
                        task.getId(), task.getStartTime().format(DATE_FORMATTER),
                        task.getDeadlineDateTime().format(DATE_FORMATTER),
                        task.getPriority(), task.getAuthor(), task.getController(),
                        task.getDescription(), task.getTimeOfCreation());
            }

            writer.printf("</TASKS>\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
