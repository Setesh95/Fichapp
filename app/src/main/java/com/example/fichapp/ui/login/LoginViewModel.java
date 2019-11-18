package com.example.fichapp.ui.login;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    private final MutableLiveData<LoginModel> loginModel = new MutableLiveData<>();

    public void loginButtonAction(String email, String password){
        Log.i("Email", email);
        Log.i("Pas", password);
    }
}