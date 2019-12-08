package com.example.fichapp.ui.history;

class RegisterHistoryModel {
    private String day;
    private String timeCheckIn;
    private String timeCheckOut;

    RegisterHistoryModel(String day, String timeIn, String timeOut) {
        this.day = day;
        timeCheckIn = timeIn;
        timeCheckOut = timeOut;
    }

    String getDay() {
        return day;
    }

    String getTimeCheckIn() {
        return timeCheckIn;
    }

    String getTimeCheckOut() {
        return timeCheckOut;
    }
}
