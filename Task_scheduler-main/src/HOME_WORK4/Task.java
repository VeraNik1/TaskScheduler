package HOME_WORK4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


class Task {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    private static int nextId = 1;
    private int id;
    private LocalDateTime startDateTime;
    private LocalDateTime deadlineDateTime;
    private LocalDateTime timeOfCreation;
    private Priority priority;
    private Employee author;
    private String description;
    private Employee controller;


    public Task(LocalDateTime startDateTime, LocalDateTime deadlineDateTime, Priority priority,
                Employee author, Employee controller, String description, LocalDateTime timeOfCreation) {
        this.id = nextId++;
        this.startDateTime = startDateTime;
        this.deadlineDateTime = deadlineDateTime;
        this.priority = priority;
        this.author = author;
        this.description = description;
        this.controller = controller;
        this.timeOfCreation = timeOfCreation;
    }
    public Task(int idNum, LocalDateTime startDateTime, LocalDateTime deadlineDateTime, Priority priority,
                Employee author, Employee controller, String description, LocalDateTime timeOfCreation) {
        this.id = idNum;
        this.startDateTime = startDateTime;
        this.deadlineDateTime = deadlineDateTime;
        this.priority = priority;
        this.author = author;
        this.description = description;
        this.controller = controller;
        this.timeOfCreation = timeOfCreation;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startDateTime;
    }

    public LocalDateTime getDeadlineDateTime() {
        return deadlineDateTime;
    }
    public LocalDateTime getTimeOfCreation() {
        return timeOfCreation;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getAuthor() {
        return author.toString();
    }
    public String getController() {
        return controller.toString();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadlineDateTime(LocalDateTime deadlineDateTime) {
        this.deadlineDateTime = deadlineDateTime;
    }



    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", start =" + startDateTime.format(DATE_FORMATTER) +
                ", end =" + deadlineDateTime.format(DATE_FORMATTER) +
                ", added =" + timeOfCreation.format(DATE_FORMATTER) +
                ", priority =" + priority +
                ", author = " + author +
                ", controller = " + controller +
                ", description = "+ '\''+ description + '\'' + "}";
    }
}