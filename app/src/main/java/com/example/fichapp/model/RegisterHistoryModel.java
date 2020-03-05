package com.example.fichapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "register_history_table")
public class RegisterHistoryModel {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int userId;
    private Date day;
    private String action;

    public RegisterHistoryModel(Date day, String action, int userId) {
        this.day = day;
        this.action = action;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDay() {
        return day;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setDay(Date day) {
        this.day = day;
    }
}
