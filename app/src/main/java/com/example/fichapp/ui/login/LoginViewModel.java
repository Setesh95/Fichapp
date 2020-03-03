package com.example.fichapp.ui.login;

import android.app.Application;

import com.example.fichapp.data.FichappRepository;
import com.example.fichapp.utils.Constants;
//import com.example.fichapp.repository.Repository;
import com.example.fichapp.model.UserModel;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class LoginViewModel extends AndroidViewModel {
    MutableLiveData<String> response = new MutableLiveData<>();
    private FichappRepository repository;
    private UserModel user;

    LoginViewModel(Application application){
        super(application);
        repository = new FichappRepository(application);
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
                Constants.USER_ID = user.getId();
                Constants.USER_IS_WORKING = user.isWorking();
            } else {
                response.setValue(Constants.WRONG_PASSWORD);
            }
        } else {
            response.setValue(Constants.USER_NOT_FOUND);
        }
    }
}