package com.bynaric.internshipcodealpha;



public class Event {
    String icon, title, time;

    public Event(String icon, String title, String time) {
        this.icon = icon;
        this.title = title;
        this.time = time;
    }

    public String getIcon() { return icon; }
    public String getTitle() { return title; }
    public String getTime() { return time; }
}

