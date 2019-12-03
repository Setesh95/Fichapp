package com.example.fichapp.ui.singing;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.fichapp.repository.Repository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SingInViewModel extends ViewModel {

    private Repository repository;
    public MutableLiveData<Boolean> registerStatus = new MutableLiveData<>();
    public MutableLiveData<Boolean> pausedStatus = new MutableLiveData<>();
    public MutableLiveData<String> lastAction = new MutableLiveData<>();
    public MutableLiveData<String> currentTimeWorked = new MutableLiveData<>();

    SingInViewModel(Context context){
        repository = Repository.get();
        repository.setContext(context);
        registerStatus.setValue(false);
        pausedStatus.setValue(true);
        lastAction.setValue("00:00h");
        currentTimeWorked.setValue("00:00m");
    }
    public void signInAction(){
        if(registerStatus.getValue() != null) {
            registerStatus.setValue(true);
        }
        if(pausedStatus.getValue() != null){
            pausedStatus.setValue(!pausedStatus.getValue());
        }
        Date calendar = Calendar.getInstance().getTime();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy HH:mm:ss", Locale.getDefault());

        String date = format.format(calendar);
        repository.registerAction(date);
    }

    public void signOut(){
        registerStatus.setValue(false);
        pausedStatus.setValue(false);
    }
}
