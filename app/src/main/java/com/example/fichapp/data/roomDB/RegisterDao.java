package com.example.fichapp.data.roomDB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.fichapp.data.roomDB.models.RegisterHistoryModel;

import java.util.List;

@Dao
public interface RegisterDao {

    @Insert
    void insertRegister(RegisterHistoryModel register);

    @Query("SELECT * FROM register_history_table where userId = :userId order by day ASC")
    LiveData<List<RegisterHistoryModel>> getRegisterListByUserId(int userId);

    @Query("SELECT * FROM register_history_table where userId = :userId order by day DESC limit 1")
    LiveData<RegisterHistoryModel> getLastRegister(int userId);
}