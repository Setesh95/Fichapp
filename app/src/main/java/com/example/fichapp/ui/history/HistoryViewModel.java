package com.example.fichapp.ui.history;

import android.content.Context;
import com.example.fichapp.repository.Repository;
import java.util.ArrayList;
import java.util.Date;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import static com.example.fichapp.utils.DateUtils.dateToClockString;
import static com.example.fichapp.utils.DateUtils.toDateString;

public class HistoryViewModel extends ViewModel {
    private Repository repository;
    private ArrayList<Date> dateList;
    private ArrayList<RegisterHistoryModel> historyList = new ArrayList<>();
    public MutableLiveData<Boolean> empryList = new MutableLiveData<>();
    HistoryViewModel (Context context){
        empryList.setValue(true);
        repository = Repository.get();
        repository.setContext(context);
        dateList = repository.getDateList();
        filterList();
    }

    private void filterList(){
        RegisterHistoryModel history;
        boolean cond = true;
        boolean cond1;
        cond1 = dateList.size() % 2 == 0;
        String day = "";
        String timeIn = "";
        String timeOut;
        Date olderDate;
        if (!dateList.isEmpty()){
            for(int i=0; i < dateList.size(); i++){
                if(i+1 == dateList.size()){
                    if(!cond1) {
                        olderDate = dateList.get(i);
                        day = toDateString(olderDate);
                        timeIn = dateToClockString(olderDate);
                        timeOut = "np/na";
                        history = new RegisterHistoryModel(day, timeIn, timeOut);
                        historyList.add(history);
                    }
                } else if (cond){
                    olderDate = dateList.get(i);
                    day = toDateString(olderDate);
                    timeIn = dateToClockString(olderDate);
                    cond = false;
                } else {
                    olderDate = dateList.get(i);
                    timeOut = dateToClockString(olderDate);
                    history = new RegisterHistoryModel(day,timeIn,timeOut);
                    historyList.add(history);
                    cond = true;
                }
            }
        }
    }

    public ArrayList<RegisterHistoryModel> getHistoryList() {
        return historyList;
    }
}
