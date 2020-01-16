package com.example.fichapp.ui.registry;
import android.app.Application;
import com.example.fichapp.data.UserRepository;
import com.example.fichapp.repository.Constants;
import com.example.fichapp.model.UserModel;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class RegisterViewModel extends AndroidViewModel {
    MutableLiveData<String> response = new MutableLiveData<>();
    private UserRepository repository;
    private UserModel user;

    RegisterViewModel(Application application) {
        super(application);

        Thread thread = new Thread(() -> repository = new UserRepository(application));
        thread.start();
    }

    void registerNewUser(String company, String email, String password, String passwordRepeat) {
        UserModel newUser = new UserModel(company, email, password);

        Thread thread = new Thread(() -> user = repository.getUserById(email));
        thread.start();

        try {
            thread.join();
        } catch (Exception e){
            response.setValue(Constants.UNKNOWN_ERROR);
        }

        if (user != null) {
            response.setValue(Constants.EMAIL_ALREADY_REGISTERED);
        } else {
            if (!password.contains(" ")) {
                if (password.equals(passwordRepeat)) {
                    repository.insert(newUser);
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
