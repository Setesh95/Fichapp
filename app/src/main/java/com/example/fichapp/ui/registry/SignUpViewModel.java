package com.example.fichapp.ui.registry;
import android.app.Application;
import com.example.fichapp.data.FichappRepository;
import com.example.fichapp.utils.Constants;
import com.example.fichapp.data.roomDB.models.UserModel;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class SignUpViewModel extends AndroidViewModel {
    MutableLiveData<String> response = new MutableLiveData<String>();
    private FichappRepository repository;
    private UserModel user;

    SignUpViewModel(Application application) {
        super(application);
        repository = new FichappRepository(application);
    }

    void registerNewUser(String company, String email, String password, String passwordRepeat) {
        final UserModel newUser = new UserModel(company, email, password);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                user = repository.getUserById(newUser.getEmail());
            }
        });
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
                    repository.insertUser(newUser);
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
