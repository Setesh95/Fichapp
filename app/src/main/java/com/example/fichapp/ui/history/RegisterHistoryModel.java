package com.example.fichapp.ui.history;

public class RegisterHistoryModel {
    private String day;
    private String timeCheckIn;
    private String timeCheckOut;

    public RegisterHistoryModel(String day, String timeIn, String timeOut) {
        this.day = day;
        timeCheckIn = timeIn;
        timeCheckOut = timeOut;
    }

    public String getDay() {
        return day;
    }

    public String getTimeCheckIn() {
        return timeCheckIn;
    }

    public String getTimeCheckOut() {
        return timeCheckOut;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setTimeCheckIn(String timeCheckIn) {
        this.timeCheckIn = timeCheckIn;
    }

    public void setTimeCheckOut(String timeCheckOut) {
        this.timeCheckOut = timeCheckOut;
    }
}
