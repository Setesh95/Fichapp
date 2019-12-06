package com.example.fichapp.ui.history;

import android.content.Context;

import com.example.fichapp.repository.Repository;

import java.util.ArrayList;
import java.util.Date;

import androidx.lifecycle.ViewModel;

public class HistoryViewModel extends ViewModel {
    private Repository repository;
    private ArrayList<Date> dateList;
    private ArrayList<RegisterHistoryModel> historyList = new ArrayList<>();
    HistoryViewModel (Context context){
        repository = Repository.get();
        repository.setContext(context);
        dateList = repository.getDateList();

    }

    private void filterList(){
        if (!dateList.isEmpty()){
            
        }
    }

    public ArrayList<RegisterHistoryModel> getHistoryList() {
        return historyList;
    }
}
