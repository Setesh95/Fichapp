package com.example.fichapp.ui.registry;

import android.content.Context;
import com.example.fichapp.repository.Constants;
import com.example.fichapp.repository.UserModel;
import com.example.fichapp.repository.Repository;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RegisterViewModel extends ViewModel {
    private Repository repository;
    MutableLiveData<String> response = new MutableLiveData<>();

    RegisterViewModel(Context context) {
        repository = Repository.get();
        repository.setContext(context);
    }

    void registerActionButton(String company, String email, String password, String passwordRepeat) {
        UserModel user = new UserModel(company, email, password);
        if (repository.findUser(user)) {
            response.setValue(Constants.USER_ALREDY_REGISTERED);
        } else {
            if (!password.contains(" ")) {
                if (password.equals(passwordRepeat)) {
                    repository.addUser(user);
                    response.setValue(Constants.REGISTERED_SUCCESSFULLY);
                } else {
                    response.setValue(Constants.PASSWORD_NOT_MATCH);
                }
            } else {
                response.setValue(Constants.PASSWORD_CONTAINS_SPACE);
            }
        }
    }
}
