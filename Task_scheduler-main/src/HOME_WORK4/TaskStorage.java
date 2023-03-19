package HOME_WORK4;

import java.util.List;

public interface TaskStorage<T extends Task> {
    /**
     * @param task Add a new task
     */
    void add(T task);

    /**
     * @param id Delete the task by its id
     */
    void remove(int id);

    /**
     * @param id View the task with the id
     */
    T getById(int id);

    /**
     * @return View the task list
     */
    List<T> getAll();
}
