package com.example.fichapp.data.roomDB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.fichapp.data.roomDB.models.UserModel;
import java.util.List;

/* TODO Create database online
* - Database INS Joan d'Àustria
* Server: 192.168.00.22
* User: maggy
* Password: Sendo123.
 */

@Dao
public interface UserDao {

    @Insert
    void insertUser(UserModel user);

    @Query("DELETE FROM user_table where id = :id")
    void deleteUserById(int id);

    @Query("SELECT * FROM user_table")
    List<UserModel> getAllUsers();

    @Query("SELECT * FROM user_table where email = :email")
    UserModel getUserByEmail(String email);
}
