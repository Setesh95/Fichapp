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
import static com.example.fichapp.model.RegisterStateModel.SIGN_IN;
import static com.example.fichapp.model.RegisterStateModel.SING_OUT;

//TODO refactor this shit code 

public class RegisterViewModel extends ViewModel {
    private FichappRepository repository;
    public MutableLiveData<String> lastAction = new MutableLiveData<String>();
    public MutableLiveData<String> currentTimeWorked = new MutableLiveData<String>();
    public MutableLiveData<Boolean> buttonDisabled = new MutableLiveData<Boolean>();
    public LiveData<RegisterHistoryModel> lastRegister;
    public MutableLiveData<String> statusModel = new MutableLiveData<String>();

    RegisterViewModel(Application application) {
        repository = new FichappRepository(application);
        disableButton();
        lastRegister = repository.getLastRegister(Constants.USER_ID);
    }

    void setTime(){
        if(lastRegister.getValue() != null) {
            enableButton();
            Date date = lastRegister.getValue().getDay();
            lastAction.setValue(DateUtils.toTimeString(date));
            statusModel.setValue(lastRegister.getValue().getAction());
        }
    }

    void enableButton(){
        buttonDisabled.setValue(true);
    }

    void disableButton(){
        buttonDisabled.setValue(false);
    }

    public void signInAction() {
        Date date = Calendar.getInstance().getTime();
        if(lastRegister.getValue() != null) {
            if(statusModel.getValue().equals(SIGN_IN.toString())){
                statusModel.setValue(SING_OUT.toString());
            } else {
                statusModel.setValue(SIGN_IN.toString());
            }
            RegisterHistoryModel register = new RegisterHistoryModel(
                    date,
                    statusModel.getValue(),
                    Constants.USER_ID
            );
            repository.insertRegister(register);
        } else {
            RegisterHistoryModel register = new RegisterHistoryModel(
                    date,
                    SIGN_IN.toString(),
                    Constants.USER_ID
            );
            repository.insertRegister(register);
        }
    }
}
