package com.example.fichapp.ui.login;

import android.content.Context;

import com.example.fichapp.model.UserModel;
import com.example.fichapp.repository.Repository;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
    private Repository repository;

    LoginViewModel(Context context){
        repository = Repository.get();
        repository.setContext(context);
    }

    boolean loginActionButton(String email, String password){
        UserModel user = new UserModel(email,password);
        return repository.findUser(user);
    }
}