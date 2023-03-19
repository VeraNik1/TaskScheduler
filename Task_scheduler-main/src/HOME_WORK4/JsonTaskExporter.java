package HOME_WORK4;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class JsonTaskExporter implements TaskExporter<Task> {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public void export(List<Task> tasks, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.printf("[\n");
            int last = tasks.size() - 1;
            for (int i =0; i < last; i++) {
                writer.printf("{\"task id\": %s,\n\"startDate\": \"%s\",\n\"DeadLine\": " +
                                "\"%s\",\n\"Priority\": \"%s\",\n\"Task author\": \"%s\",\n\"Task controller\": \"%s\"," +
                                "\n\"Task description\": \"%s\",\n\"Date of creation\": \"%s\"\n},\n",
                        tasks.get(i).getId(), tasks.get(i).getStartTime().format(DATE_FORMATTER),
                        tasks.get(i).getDeadlineDateTime().format(DATE_FORMATTER),
                        tasks.get(i).getPriority(), tasks.get(i).getAuthor(), tasks.get(i).getController(),
                        tasks.get(i).getDescription(), tasks.get(i).getTimeOfCreation());
            }
            writer.printf("{\"task id\": %s,\n\"startDate\": \"%s\",\n\"DeadLine\": " +
                            "\"%s\",\n\"Priority\": \"%s\",\n\"Task author\": \"%s\",\n\"Task controller\": \"%s\"," +
                            "\n\"Task description\": \"%s\",\n\"Date of creation\": \"%s\"\n}\n",
                    tasks.get(last).getId(), tasks.get(last).getStartTime().format(DATE_FORMATTER),
                    tasks.get(last).getDeadlineDateTime().format(DATE_FORMATTER),
                    tasks.get(last).getPriority(), tasks.get(last).getAuthor(), tasks.get(last).getController(),
                    tasks.get(last).getDescription(), tasks.get(last).getTimeOfCreation());
            writer.printf("]\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
