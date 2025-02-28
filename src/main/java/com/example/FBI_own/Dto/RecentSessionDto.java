package com.example.FBI_own.Dto;

public class RecentSessionDto {

    private String title;
    private String date;// Using String to receive date in "yyyy-MM-dd" format
    private String time;

    // Constructor
    public RecentSessionDto() {}

    public RecentSessionDto(String title, String date, String time) {
        this.title=title;
        this.date=date;
        this.time=time;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
