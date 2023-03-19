package HOME_WORK4;

import java.util.List;

public interface TaskExporter <T extends Task> {
    /**
     * @param tasks the task list for export
     * @param filePath name of the file
     */
    void export(List<T> tasks, String filePath);

}

