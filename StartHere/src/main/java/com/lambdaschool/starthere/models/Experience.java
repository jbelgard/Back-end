package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "experience")
public class Experience extends Auditable {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private long experienceid;

    @Column(unique = true,
            nullable = false)

    private long hostid;
    private String title;
    private String body;
    private int attendees;
    private int slots;
    private int cost;

    @JsonIgnoreProperties("experience")

    public Experience() {

    }

    public Experience (String title, String body, int attendees, int slots, int cost) {
        this.title = title;
        this.body = body;
        this.attendees = attendees;
        this.slots = slots;
        this.cost = cost;


    }

    public long getExperienceid() { return experienceid; }

    public void setExperienceid(long experienceid) {
        this.experienceid = experienceid;
    }

    public long getHostId() {
        return hostid;
    }

    public void setHostId() {
        this.hostid = hostid;
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

    public void setBody(String body) {
        this.body = body;
    }

    public int getAttendees() {
        return attendees;
    }

    public void setAttendees(int attendees) {
        this.attendees = attendees;
    }

    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots = slots;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }


}
