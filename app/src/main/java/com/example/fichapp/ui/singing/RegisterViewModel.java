package com.example.fichapp.ui.singing;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.fichapp.data.FichappRepository;
import com.example.fichapp.model.RegisterHistoryModel;
import com.example.fichapp.utils.Constants;
import com.example.fichapp.utils.DateUtils;
import java.util.Calendar;
import java.util.Date;

//TODO refactor this shit code 

public class RegisterViewModel extends ViewModel {
    private FichappRepository repository;
    public MutableLiveData<String> lastAction = new MutableLiveData<>();
    public MutableLiveData<String> currentTimeWorked = new MutableLiveData<>();
    public MutableLiveData<Boolean> buttonDisabled = new MutableLiveData<>();
    public LiveData<RegisterHistoryModel> lastRegister;

    RegisterViewModel(Application application) {
        repository = new FichappRepository(application);
        lastRegister = repository.getLastRegister(Constants.USER_ID);
    }

    public void setTime(){
        Date date = DateUtils.stringToDate(lastRegister.getValue().getDay());
        lastAction.setValue(DateUtils.toTimeString(date));
        date.compareTo();
    }

    public void signInAction() {
        buttonDisabled.setValue(false);
        Calendar calendar = Calendar.getInstance();
        if(lastRegister.getValue() != null) {
            System.out.println(lastRegister.getValue().getAction());
        } else {
            RegisterHistoryModel register = new RegisterHistoryModel(
                    DateUtils.toDateString(calendar.getTime()),
                    "SIGN_IN",
                    Constants.USER_ID
            );
            repository.insertRegister(register);
        }
        buttonDisabled.setValue(true);

        /*String action = "";
        Calendar calendar = Calendar.getInstance();
        if (lastRegister == null || lastRegister.setAction() != null) {
            RegisterHistoryModel register = new RegisterHistoryModel(
                    DateUtils.toDateString(calendar.getTime()),
                    action,
                    Constants.USER_ID
            );
            repository.insertRegister(register);
            Constants.REGISTER_LIST.getValue().add(register);
        } else {
            repository.updateCheckOut(lastRegister.getId(), DateUtils.toTimeString(calendar.getTime()));
        }*/
    }
}
