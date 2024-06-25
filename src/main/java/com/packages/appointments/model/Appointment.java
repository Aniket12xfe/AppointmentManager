package com.packages.appointments.model;

public class Appointment {
    private int id;
    private String username;
    private String date;
    private String time;
    private String description;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Appointment(int id, String username, String date, String time, String description) {
        this.id = id;
        this.username = username;
        this.date = date;
        this.time = time;
        this.description = description;
    }

    public Appointment(String username, String date, String time, String description) {
        this.username = username;
        this.date = date;
        this.time = time;
        this.description = description;
    }

    // Getters and Setters
}
