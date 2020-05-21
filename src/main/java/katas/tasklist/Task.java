package katas.tasklist;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class Task {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private final long id;
    private final String description;
    private boolean done;
    private LocalDate dueDate;

    public Task(long id, String description, boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
    }

    public long getId() {
        return id;
    }

    public void markDone(boolean done) {
        this.done = done;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = LocalDate.parse(dueDate, DATE_FORMAT);
    }

    public boolean isDueToday() {
        return dueDate != null && getFormattedDate(dueDate).equals(getFormattedDate(LocalDate.now()));
    }

    private String getFormattedDate(LocalDate date){
        return date.format(DATE_FORMAT);
    }

    public String getFormattedDetails() {
        return String.format("[%c] %d: %s%s", (done ? 'x' : ' '), id, description, dueDate != null ? " due: " + dueDate : "");
    }
}
