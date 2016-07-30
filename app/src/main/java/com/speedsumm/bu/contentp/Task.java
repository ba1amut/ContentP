package com.speedsumm.bu.contentp;

/**
 * Created by bu on 20.07.2016.
 */
public class Task {
    private int id;
    private String name;
    private String body;
    private String date;
    private int complete;

    public Task(int id, String name, String body, String date, int complete) {
        this.id = id;
        this.name = name;
        this.body = body;
        this.date = date;
        this.complete = complete;
    }

    public Task() {  }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getComplete() {
        return complete;
    }

    public void setComplete(int complete) {
        this.complete = complete;
    }
}
