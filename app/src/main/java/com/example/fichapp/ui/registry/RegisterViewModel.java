package com.example.fichapp.ui.registry;

import android.content.Context;
import com.example.fichapp.ui.login.UserModel;
import com.example.fichapp.repository.Repository;
import androidx.lifecycle.ViewModel;

public class RegisterViewModel extends ViewModel {
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
