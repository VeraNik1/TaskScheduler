package HOME_WORK4;

public interface TaskImporter <T extends Task> {
    /**
     * @param filePath name of the file
     * @return task list from file
     */
    TaskManager<T> importTasks(String filePath);
}
