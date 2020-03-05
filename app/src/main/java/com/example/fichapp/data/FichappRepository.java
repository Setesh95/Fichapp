package com.example.fichapp.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.fichapp.model.RegisterHistoryModel;
import com.example.fichapp.model.UserModel;

import java.util.List;

public class FichappRepository {

    private RegisterDao registerDao;
    private UserDao userDao;

    public FichappRepository(Application application) {
        FichappRoomDb fichappRoomDb = FichappRoomDb.getDatabase(application.getApplicationContext());
        userDao = fichappRoomDb.fichappDao();
        registerDao = fichappRoomDb.registerDao();
    }

    public List<UserModel> getAllUsers() {
        return userDao.getAllUsers();
    }

    public UserModel getUserById(String email) {
        return userDao.getUserByEmail(email);
    }

    public LiveData<List<RegisterHistoryModel>> getRegistersByUserId(int userId) {
        return registerDao.getRegisterListByUserId(userId);
    }

    public LiveData<RegisterHistoryModel> getLastRegister(int userId){
        return registerDao.getLastRegister(userId);
    }

    /*public void updateCheckOut(final int id, final String timeCheckOut) {
        FichappRoomDb.databaseWriterExecutor.execute(() -> {
            registerDao.updateCheckOut(id, timeCheckOut);
        });
    }*/

    public void insertRegister(final RegisterHistoryModel register) {
        FichappRoomDb.databaseWriterExecutor.execute(new Runnable() {
            @Override
            public void run() {
                registerDao.insertRegister(register);
            }
        });
    }

    public void insertUser(final UserModel user) {
        FichappRoomDb.databaseWriterExecutor.execute(new Runnable() {
            @Override
            public void run() {
                userDao.insertUser(user);
            }
        });
    }
}
