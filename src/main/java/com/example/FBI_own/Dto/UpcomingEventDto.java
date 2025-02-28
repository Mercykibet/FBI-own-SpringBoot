package com.example.FBI_own.Dto;

public class UpcomingEventDto {

    private String title;
    private String place;
    private String date; // Using String to receive date in "yyyy-MM-dd" format


    public UpcomingEventDto(String title, String place, String date) {
        this.title = title;
        this.place = place;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
