package com.example.fichapp.data;

import android.app.Application;

import com.example.fichapp.model.UserModel;

import java.util.List;

public class UserRepository {

    private UserDao userDao;
    private List<UserModel> userModelList;

    public UserRepository(Application application) {
        UserRoomDatabase userRoomDatabase = UserRoomDatabase.getDatabase(application.getApplicationContext());
        userDao = userRoomDatabase.userDao();
    }

    public List<UserModel> getAllUsers() {
        return userModelList;
    }

    public UserModel getUserById(String email) {
        return userDao.getUserByEmail(email);
    }

    public void insert(final UserModel user) {
        UserRoomDatabase.databaseWriterExecutor.execute(() -> {
            userDao.insert(user);
        });
    }
}
