package com.example.fichapp.ui.history;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

//import com.example.fichapp.repository.Repository;

import java.util.ArrayList;

public class HistoryViewModel extends ViewModel {
//    private Repository repository;
    private ArrayList<RegisterHistoryModel> historyList;
    public MutableLiveData<Boolean> empryList = new MutableLiveData<>();

    HistoryViewModel(Context context) {
        empryList.setValue(true);
//        repository = Repository.get();
//        repository.setContext(context);
//        historyList = repository.getDateList();
    }

    ArrayList<RegisterHistoryModel> getHistoryList() {

        //TODO review

        ArrayList<RegisterHistoryModel> historyListMinusLast = new ArrayList<>();
        if (!historyList.isEmpty()) {
            for (RegisterHistoryModel history : historyList) {
                if (history.getTimeCheckOut() != null) {
                    historyListMinusLast.add(history);
                }
            }
        }

        return historyListMinusLast;
    }
}
