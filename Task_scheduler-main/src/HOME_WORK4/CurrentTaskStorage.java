package HOME_WORK4;

import java.util.ArrayList;
import java.util.List;

class CurrentTaskStorage implements TaskStorage {
    private List<Task> tasks = new ArrayList<>();

    @Override
    public void add(Task task) {
        tasks.add(task);
    }

    @Override
    public void remove(int id) {
        tasks.removeIf(task -> task.getId() == id);
    }

    @Override
    public Task getById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    @Override
    public List<Task> getAll() {
        return tasks;
    }
}
