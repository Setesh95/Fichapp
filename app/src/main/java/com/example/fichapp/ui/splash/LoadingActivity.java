package com.example.fichapp.ui.splash;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fichapp.R;
import com.example.fichapp.data.FichappRepository;
import com.example.fichapp.model.RegisterHistoryModel;
import com.example.fichapp.repository.Constants;
import com.example.fichapp.ui.history.ItemListAdapter;
import com.example.fichapp.ui.main.MainActivity;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        FichappRepository repository = new FichappRepository(getApplication());
        Constants.REGISTER_LIST = repository.getRegistersByUserId(Constants.USER_ID);
        setObserver();
    }

    private void launchApp() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    private void setObserver() {
        Constants.REGISTER_LIST.observe(this, registerHistoryModels -> launchApp());
    }
}
