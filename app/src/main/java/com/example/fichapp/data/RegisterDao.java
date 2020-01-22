package com.example.fichapp.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.fichapp.model.RegisterHistoryModel;

import java.util.List;

@Dao
public interface RegisterDao {

    @Insert
    void insertRegister(RegisterHistoryModel register);

    @Query("SELECT * FROM register_history_table where userId = :userId")
    LiveData<List<RegisterHistoryModel>> getRegisterListByUserId(int userId);

    @Query("UPDATE register_history_table set timeCheckOut = :timeCheckOut where id = :id")
    void updateCheckOut(int id, String timeCheckOut);
}