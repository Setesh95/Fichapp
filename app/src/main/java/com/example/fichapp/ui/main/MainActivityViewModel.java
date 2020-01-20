package com.example.fichapp.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    MutableLiveData<NavigatorStatus.status> navigationStatus = new MutableLiveData<>();
    MainActivityViewModel(){
        navigationStatus.setValue(NavigatorStatus.status.CHEK_IN_OUT);
    }
    public void navigateToHistory(){
        navigationStatus.setValue(NavigatorStatus.status.REGISTER_HISTORY);
    }
    public void navigateToSign(){
        navigationStatus.setValue(NavigatorStatus.status.CHEK_IN_OUT);
    }
    public void navigateToConfig() {
        navigationStatus.setValue(NavigatorStatus.status.CONFIG);
    }
}
