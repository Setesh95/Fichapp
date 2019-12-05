package com.example.fichapp.ui.login;

import android.content.Context;
import com.example.fichapp.repository.Constants;
import com.example.fichapp.repository.Repository;
import com.example.fichapp.repository.UserModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
    private Repository repository;
    MutableLiveData<String> response = new MutableLiveData<>();

    LoginViewModel(Context context){
        repository = Repository.get();
        repository.setContext(context);
    }

    void loginActionButton(String email, String password){
        UserModel user = new UserModel(email,password);
        if(repository.findUser(user)){
            if (repository.checkPassword(user)){
                response.setValue(Constants.LOGIN_SUCCESSFULLY);
            } else {
                response.setValue(Constants.WRONG_PASSOWRD);
            }
        } else {
            response.setValue(Constants.USER_NOT_FOUND);
        }
    }
}