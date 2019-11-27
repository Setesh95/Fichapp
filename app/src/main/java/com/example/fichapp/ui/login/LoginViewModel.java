package com.example.fichapp.ui.login;

import android.content.Context;

import com.example.fichapp.ui.repository.Repository;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
    private Repository repository;

    LoginViewModel(Context context){
        repository = Repository.get();
        repository.setContext(context);
    }

    void loginButtonAction(String email, String password){
        UserModel user = new UserModel(email,password);
        repository.findUser(user);
    }
}