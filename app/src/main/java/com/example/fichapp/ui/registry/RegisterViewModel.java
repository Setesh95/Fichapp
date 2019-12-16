package com.example.fichapp.ui.registry;

import android.app.Application;
import android.content.Context;

import com.example.fichapp.data.UserRepository;
import com.example.fichapp.repository.Constants;
import com.example.fichapp.model.UserModel;
//import com.example.fichapp.repository.Repository;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class RegisterViewModel extends AndroidViewModel {
//    private Repository repository;
    MutableLiveData<String> response = new MutableLiveData<>();
    private UserRepository repository;
    private List<UserModel> userModelList;

    public RegisterViewModel(Application application) {
        super(application);

        Thread thread = new Thread(() -> repository = new UserRepository(application));
        thread.start();
//        repository.setContext(context);
    }

    void registerNewUser(String company, String email, String password, String passwordRepeat) {
        UserModel user = new UserModel(company, email, password);

        repository.insert(user);

        System.out.println(repository.getAllUsers().size());

//        if (repository.findUser(user)) {
//            response.setValue(Constants.EMAIL_ALREADY_REGISTERED);
//        } else {
//            if (!password.contains(" ")) {
//                if (password.equals(passwordRepeat)) {
//                    repository.addUser(user);
//                    response.setValue(Constants.REGISTERED_SUCCESSFULLY);
//                } else {
//                    response.setValue(Constants.PASSWORD_NOT_MATCH);
//                }
//            } else {
//                response.setValue(Constants.PASSWORD_CONTAINS_SPACE);
//            }
//        }
    }
}
