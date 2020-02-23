package com.example.fichapp.ui.config;

import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ConfigViewModel extends ViewModel {
    private MutableLiveData<String> mWeb;

    public ConfigViewModel() {
        mWeb = new MutableLiveData<>();
    }


    public MutableLiveData<String> getWeb() {
        return mWeb;
    }
    public void downloadURL(String web){
        HttpURLConnection connection;
        URL url;
        String result;
        result ="";

        try{

            url = new URL(web);
            connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();

            int data = inputStream.read();

            while(data != -1){
                result += (char) data;
                data = inputStream.read();
            }

        }catch (Exception e){

            e.printStackTrace();

        }

        Log.i("RESULT", result);

        mWeb.postValue(result);

    }
}
