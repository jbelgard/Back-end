package com.lambdaschool.starthere.models;

public class Experience {

    private long hostid;
    private String title;
    private String body;
    private int attendees;
    private int slots;
    private int cost;

    public long getHostId() {
        return hostid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody(){
        return body;
    }

    public int getAttendees() {
        return attendees;
    }

    public int getSlots() {
        return slots;
    }

    public int getCost() {
        return cost;
    }
}
