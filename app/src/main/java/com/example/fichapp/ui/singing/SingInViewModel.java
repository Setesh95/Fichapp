package com.example.fichapp.ui.singing;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.fichapp.repository.Repository;
import com.example.fichapp.utils.DateUtils;
import java.util.Calendar;
import java.util.Date;

public class SingInViewModel extends ViewModel {

    private Repository repository;
    //public MutableLiveData<Boolean> registerStatus = new MutableLiveData<>();
    MutableLiveData<Boolean> pausedStatus = new MutableLiveData<>();
    public MutableLiveData<String> lastAction = new MutableLiveData<>();
    public MutableLiveData<String> currentTimeWorked = new MutableLiveData<>();
    private Date calendar;

    SingInViewModel(Context context){
        repository = Repository.get();
        repository.setContext(context);
        pausedStatus.setValue(false);
        lastAction.setValue("00:00h");
        currentTimeWorked.setValue("00:00m");
    }
    public void signInAction(){
        if(pausedStatus.getValue() != null){
            pausedStatus.setValue(!pausedStatus.getValue());
        }
        calendar = Calendar.getInstance().getTime();
        String lastAction = DateUtils.dateToClockString(calendar) + 'h';
        this.lastAction.setValue(lastAction);
        repository.registerAction(calendar);
    }
}
