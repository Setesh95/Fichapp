package com.example.fichapp.ui.login;

import android.app.Application;
import android.content.Context;

import com.example.fichapp.data.UserRepository;
import com.example.fichapp.repository.Constants;
//import com.example.fichapp.repository.Repository;
import com.example.fichapp.model.UserModel;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends AndroidViewModel {
    MutableLiveData<String> response = new MutableLiveData<>();
    private UserRepository repository;
    private UserModel user;

    LoginViewModel(Application application){
        super(application);

        Thread thread = new Thread(() -> repository = new UserRepository(application));
        thread.start();
    }

     void loginActionButton(String email, String password){
        Thread thread = new Thread(() -> user = repository.getUserById(email));
        thread.start();


        try {
            thread.join();
        } catch (Exception e){
            response.setValue(Constants.UNKNOWN_ERROR);
        }

        if (user != null) {
            if (password.equals(user.getPassword())) {
                response.setValue(Constants.LOGIN_SUCCESSFULLY);
            } else {
                response.setValue(Constants.WRONG_PASSWORD);
            }
        } else {
            response.setValue(Constants.USER_NOT_FOUND);
        }
    }
}