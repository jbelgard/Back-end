package com.lambdaschool.starthere.models;

public class Host {
    private long hostid;
    private int price;
    private int attendees;
    private int pay;
    private String title;
    private String body;
    private int cost;

    public long getHostId() {
        return hostid;
    }

    public void setHostId(long hostid) {
        this.hostid = hostid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAttendees() {
        return attendees;
    }

    public void setAttendees(int attendees) {
        this.attendees = attendees;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void getBody(String body) {
        this.body = body;
    }
}
