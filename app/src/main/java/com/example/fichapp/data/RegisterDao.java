package com.example.fichapp.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.fichapp.model.RegisterHistoryModel;

import java.util.List;

@Dao
public interface RegisterDao {

    @Insert
    void insertRegister(RegisterHistoryModel register);

    @Query("SELECT * FROM register_history_table where userId = :userId")
    LiveData<List<RegisterHistoryModel>> getRegisterListByUserId(int userId);

    @Query("SELECT * FROM register_history_table where userId = :userId order by id ASC limit 1")
    LiveData<RegisterHistoryModel> getLastRegister(int userId);
}