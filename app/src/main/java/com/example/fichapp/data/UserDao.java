package com.example.fichapp.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.fichapp.model.UserModel;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Dao
public interface UserDao {

    @Insert
    void insert(UserModel user);

    @Query("DELETE FROM user_table where id = :id")
    void deleteUserById(int id);

    @Query("SELECT * FROM user_table")
    List<UserModel> getAllUsers();

}
