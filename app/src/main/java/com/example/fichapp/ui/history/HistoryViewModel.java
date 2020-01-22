package com.example.fichapp.ui.history;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

//import com.example.fichapp.repository.Repository;

import com.example.fichapp.data.FichappRepository;
import com.example.fichapp.model.RegisterHistoryModel;
import com.example.fichapp.repository.Constants;

import java.util.ArrayList;
import java.util.List;

public class HistoryViewModel extends ViewModel {
    private ArrayList<RegisterHistoryModel> historyList;
    public MutableLiveData<Boolean> empryList = new MutableLiveData<>();
    public FichappRepository repository;
    public LiveData<List<RegisterHistoryModel>> registerList;

    HistoryViewModel(Application application) {
        empryList.setValue(true);
        repository = new FichappRepository(application);
        getHistoryList();
//        repository = Repository.get();
//        repository.setContext(context);
//        historyList = repository.getDateList();
    }

    public void getHistoryList() {

        registerList = repository.getRegistersByUserId(Constants.USER_ID);

//        //TODO review
//
//        ArrayList<RegisterHistoryModel> historyListMinusLast = new ArrayList<>();
//        if (!historyList.isEmpty()) {
//            for (RegisterHistoryModel history : historyList) {
//                if (history.getTimeCheckOut() != null) {
//                    historyListMinusLast.add(history);
//                }
//            }
//        }
//
//        return historyListMinusLast;
//    }
    }
}
