package com.ray8118.model;

public class Task {
    private int todo_id;
    private String title;
    private String description;

    private boolean isCompleted;

    public Task() {
    }

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.isCompleted = false;
    }

    public int getTodo_id() {
        return todo_id;
    }

    public void setTodo_id(int id) {
        todo_id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    @Override
    public String toString() {
        return "Task [todo_id=" + todo_id + ", title=" + title + ", description=" + description + ", isCompleted="
                + isCompleted + "]";
    }

}
