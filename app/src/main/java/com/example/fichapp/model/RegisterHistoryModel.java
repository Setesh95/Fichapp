package com.example.fichapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "register_history_table")
public class RegisterHistoryModel {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int userId;

    private String day;
    private String timeCheckIn;
    private String timeCheckOut;

    public RegisterHistoryModel(String day, String timeCheckIn, String timeCheckOut, int userId) {
        this.day = day;
        this.timeCheckIn = timeCheckIn;
        this.timeCheckOut = timeCheckOut;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
