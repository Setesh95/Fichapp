package com.example.fichapp.ui.singing;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.fichapp.data.FichappRepository;
import com.example.fichapp.model.RegisterHistoryModel;
import com.example.fichapp.repository.Constants;

//import com.example.fichapp.repository.Repository;


public class SingInViewModel extends ViewModel {

    //    private Repository repository;
    //public MutableLiveData<Boolean> registerStatus = new MutableLiveData<>();
    private FichappRepository repository;
    MutableLiveData<Boolean> pausedStatus = new MutableLiveData<>();
    public MutableLiveData<String> lastAction = new MutableLiveData<>();
    public MutableLiveData<String> currentTimeWorked = new MutableLiveData<>();

    SingInViewModel(Application application) {
//        repository = Repository.get();
//        repository.setContext(context);
        pausedStatus.setValue(isPlaying());
        lastAction.setValue("00:00h");
        currentTimeWorked.setValue("00:00m");
        repository = new FichappRepository(application);
    }


    private boolean isPlaying() {
       return Constants.USER_IS_WORKING;
    }

    public void signInAction() {

        System.out.println(Constants.REGISTER_LIST.getValue());

        if (Constants.USER_IS_WORKING) {
//            repository.updateCheckOut(//TODO);
        }

//        if (pausedStatus.getValue() != null) {
//            pausedStatus.setValue(!pausedStatus.getValue());
//        }
//        Date calendar = Calendar.getInstance().getTime();
//        String lastAction = DateUtils.toTimeString(calendar) + 'h';
//        this.lastAction.setValue(lastAction);
//        repository.registerAction(calendar);
    }
}
