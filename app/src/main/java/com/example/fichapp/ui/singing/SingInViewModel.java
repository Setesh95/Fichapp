package com.example.fichapp.ui.singing;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

//import com.example.fichapp.repository.Repository;
import com.example.fichapp.ui.history.RegisterHistoryModel;
import com.example.fichapp.utils.DateUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class SingInViewModel extends ViewModel {

//    private Repository repository;
    //public MutableLiveData<Boolean> registerStatus = new MutableLiveData<>();
    MutableLiveData<Boolean> pausedStatus = new MutableLiveData<>();
    public MutableLiveData<String> lastAction = new MutableLiveData<>();
    public MutableLiveData<String> currentTimeWorked = new MutableLiveData<>();

    SingInViewModel(Context context) {
//        repository = Repository.get();
//        repository.setContext(context);
        pausedStatus.setValue(isPlaying());
        lastAction.setValue("00:00h");
        currentTimeWorked.setValue("00:00m");
    }


    private boolean isPlaying() {
////        ArrayList<RegisterHistoryModel> historyList = repository.getDateList();
//        if (historyList.isEmpty()) {
//            return false;
//        } else {
//            return historyList.get(historyList.size() - 1).getTimeCheckOut() == null;
//        }
        return true;
    }

    public void signInAction() {
//        if (pausedStatus.getValue() != null) {
//            pausedStatus.setValue(!pausedStatus.getValue());
//        }
//        Date calendar = Calendar.getInstance().getTime();
//        String lastAction = DateUtils.toTimeString(calendar) + 'h';
//        this.lastAction.setValue(lastAction);
//        repository.registerAction(calendar);
    }
}
