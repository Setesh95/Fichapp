package com.example.fichapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.fichapp.R;
import com.example.fichapp.databinding.ActivityMainBinding;
import com.example.fichapp.ui.history.HistoryFragment;
import com.example.fichapp.ui.singing.SingInFragment;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel viewModel;
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentTransaction transaction;
    private SingInFragment singInFragment = new SingInFragment();
    private HistoryFragment historyFragment = new HistoryFragment();
    ImageButton singInButton, userButton, configButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new MainActivityViewModel();
        binding.setLifecycleOwner(this);
        binding.setViewModel(viewModel);
        singInButton = findViewById(R.id.sing_in_button);
        userButton = findViewById(R.id.user_button);
        configButton = findViewById(R.id.config_button);

        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment, singInFragment);
        transaction.commit();
        userButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startHistory();
            }
        });
        singInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSingIn();
            }
        });
    }

    private void startSingIn() {
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment, singInFragment);
        transaction.commit();
    }

    private void startHistory() {
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment, historyFragment);
        transaction.commit();
    }
}
