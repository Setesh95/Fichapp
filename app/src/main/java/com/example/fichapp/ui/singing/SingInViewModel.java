package com.example.fichapp.ui.singing;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.fichapp.data.FichappRepository;
import com.example.fichapp.model.RegisterHistoryModel;
import com.example.fichapp.repository.Constants;
import com.example.fichapp.utils.DateUtils;

import java.util.Calendar;

//TODO refactor this shit code 

public class SingInViewModel extends ViewModel {
    private FichappRepository repository;
    public MutableLiveData<String> lastAction = new MutableLiveData<>();
    public MutableLiveData<String> currentTimeWorked = new MutableLiveData<>();
    private RegisterHistoryModel lastRegister;

    SingInViewModel(Application application) {
        lastAction.setValue("00:00h");
        currentTimeWorked.setValue("00:00m");
        repository = new FichappRepository(application);
        if(Constants.REGISTER_LIST.getValue() != null) {
            if (!Constants.REGISTER_LIST.getValue().isEmpty()) {
                lastRegister = Constants.REGISTER_LIST.getValue().get(Constants.REGISTER_LIST.getValue().size() - 1);
            }
        }
    }

    public void signInAction() {
        Calendar calendar = Calendar.getInstance();
        if (lastRegister == null || lastRegister.getTimeCheckOut() != null) {
            RegisterHistoryModel register = new RegisterHistoryModel(
                    DateUtils.toDateString(calendar.getTime()),
                    DateUtils.toTimeString(calendar.getTime()),
                    null,
                    Constants.USER_ID
            );
            repository.insertRegister(register);
            Constants.REGISTER_LIST.getValue().add(register);
        } else {
            repository.updateCheckOut(lastRegister.getId(), DateUtils.toTimeString(calendar.getTime()));
        }
    }
}
