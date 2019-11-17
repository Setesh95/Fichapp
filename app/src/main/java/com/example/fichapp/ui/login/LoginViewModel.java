package com.example.fichapp.ui.login;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
    public final MutableLiveData<Boolean> registerButton = new MutableLiveData<>();

    public LoginViewModel(){
        registerButton.setValue(true);
    }

    public void registerAction (){
        registerButton.setValue(false);
    }
}