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
    MutableLiveData<String> response = new MutableLiveData<>();
    public MutableLiveData<Boolean> actionButton = new MutableLiveData<>();

    SingInViewModel(Context context){
        repository = Repository.get();
        repository.setContext(context);
    }
    public void signInOutAction(){
        actionButton.setValue(true);
        Date calendar = Calendar.getInstance().getTime();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy HH:mm:ss", Locale.getDefault());
        String date = format.format(calendar);
        repository.registerAction(date);
    }
}
