package com.example.fichapp.ui.registry;

import android.content.Context;

import com.example.fichapp.repository.Constants;
import com.example.fichapp.ui.login.UserModel;
import com.example.fichapp.repository.Repository;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RegisterViewModel extends ViewModel {
    private Repository repository;
    MutableLiveData<String> response = new MutableLiveData<>();

    RegisterViewModel(Context context){
        repository = Repository.get();
        repository.setContext(context);
    }

    void registerActionButton(String company, String email, String password, String checkPassword){
        if(!password.contains(" ")) {
            if (password.equals(checkPassword)) {
                UserModel user = new UserModel(company, email, password);
                repository.addUser(user);
                response.setValue(Constants.REGISTERED_SUCCESSFULLY);
            }
            response.setValue(Constants.PASSWORD_NOT_MATCH);
        }
        response.setValue(Constants.PASSWORD_CONTAINS_SPACE);
    }
}
