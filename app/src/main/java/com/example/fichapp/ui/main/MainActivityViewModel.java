package com.example.fichapp.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    MutableLiveData<Boolean> sign = new MutableLiveData<>();
    MutableLiveData<Boolean> history = new MutableLiveData<>();
    public MainActivityViewModel(){
        sign.setValue(true);
        history.setValue(false);
    }
    public void navigateToHistory(){
        sign.setValue(false);
        history.setValue(true);
    }
    public void navigateToSign(){
        sign.setValue(true);
        history.setValue(false);
    }
}
