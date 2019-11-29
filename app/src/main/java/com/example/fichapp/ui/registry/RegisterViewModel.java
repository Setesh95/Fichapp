package com.example.fichapp.ui.registry;

import android.content.Context;

import com.example.fichapp.model.UserModel;

import com.example.fichapp.repository.Repository;

public class RegisterViewModel {
    private Repository repository;

    RegisterViewModel(Context context){
        repository = Repository.get();
        repository.setContext(context);
    }

    void registerActionButton(String company, String email, String password, String checkPassword){
        if(password.equals(checkPassword)){
        UserModel user = new UserModel(company,email,password);
        repository.addUser(user);
        }
    }
}
