package com.example.fichapp.ui.history;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.fichapp.data.FichappRepository;
import com.example.fichapp.data.roomDB.models.RegisterHistoryModel;
import com.example.fichapp.utils.Constants;

import java.util.List;

public class HistoryViewModel extends ViewModel {
    public FichappRepository repository;
    public LiveData<List<RegisterHistoryModel>> registerList;

    HistoryViewModel(Application application) {
        repository = new FichappRepository(application);
        registerList = repository.getRegistersByUserId(Constants.USER_ID);
    }
}
