package com.example.fichapp.ui.config;

import android.util.Log;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WebViewViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<String> mWeb;

    public WebViewViewModel() {
        mWeb = new MutableLiveData<>();
    }


    public MutableLiveData<String> getWeb() {
        return mWeb;
    }
    public void downloadURL(String web){
        HttpURLConnection connection;
        URL url;
        StringBuilder result;
        result = new StringBuilder();

        try{

            url = new URL(web);
            connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();

            int data = inputStream.read();

            String a = "";
            String b = a + "";

            while(data != -1){
                result.append((char) data);
                data = inputStream.read();
            }

        }catch (Exception e){

            e.printStackTrace();

        }

        Log.i("RESULT", result.toString());

        mWeb.postValue(result.toString());

    }
}