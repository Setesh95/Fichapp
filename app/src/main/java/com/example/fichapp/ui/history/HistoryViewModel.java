package com.example.fichapp.ui.history;
import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.fichapp.data.FichappRepository;
import com.example.fichapp.model.RegisterHistoryModel;
import java.util.ArrayList;

public class HistoryViewModel extends ViewModel {
    private ArrayList<RegisterHistoryModel> historyList;
    public MutableLiveData<Boolean> empryList = new MutableLiveData<>();
    public FichappRepository repository;

    HistoryViewModel(Application application) {
        empryList.setValue(true);
        repository = new FichappRepository(application);
    }
}
