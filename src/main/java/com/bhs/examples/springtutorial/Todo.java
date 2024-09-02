package com.bhs.examples.springtutorial;

public class Todo {
    private int id;
    private int userId;
    private String title;
    private boolean completed;
    public Todo(int id,int userId,String title,boolean completed){
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public boolean isCompleted() {
        return completed;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String toString() {
        return "Todo{" +
                "id = " + id + '\'' +
                ",completed = " + completed + '\'' +
                ",title = " + title + '\'' +
                ",userId = " + userId + '\'' +
                "}";
    }
}
