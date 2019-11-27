package com.example.fichapp.ui.register;

import android.content.Context;

import com.example.fichapp.ui.model.UserModel;

import data.repository.Repository;

public class RegisterViewModel {
    private Repository repository;

    RegisterViewModel(Context context){
        repository = Repository.get();
        repository.setContext(context);
    }

    void registerActionButton(String company, String email, String password, String checkPassword){
        UserModel user = new UserModel(company,email,password);
        repository.addUser(user);
    }
}
