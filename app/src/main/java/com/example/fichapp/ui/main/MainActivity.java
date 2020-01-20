package com.example.fichapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.fichapp.R;
import com.example.fichapp.databinding.ActivityMainBinding;
import com.example.fichapp.ui.config.ConfigFragment;
import com.example.fichapp.ui.history.HistoryFragment;
import com.example.fichapp.ui.singing.SingInFragment;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel viewModel;
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentTransaction transaction;
    private SingInFragment singInFragment = new SingInFragment();
    private HistoryFragment historyFragment = new HistoryFragment();
    private ConfigFragment configFragment = new ConfigFragment();
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
        setObservers();
    }

    private void setObservers() {
        viewModel.navigationStatus.observe(this, status -> {
            switch (status) {
                case CHEK_IN_OUT:
                    startSingIn();
                    cleanDrawable();
                    singInButton.setBackground(getDrawable(R.color.selectedNavButton));
                    singInButton.setImageResource(R.drawable.ic_hora_selected);
                    break;
                case REGISTER_HISTORY:
                    startHistory();
                    cleanDrawable();
                    userButton.setBackground(getDrawable(R.color.selectedNavButton));
                    userButton.setImageResource(R.drawable.ic_avatar_selected);
                    break;
                case CONFIG:
                    startConfig();
                    cleanDrawable();
                    configButton.setBackground(getDrawable(R.color.selectedNavButton));
                    configButton.setImageResource(R.drawable.ic_global_selected);
                    break;
                default:
                    break;
            }
        });
    }

    private void cleanDrawable() {
        singInButton.setBackground(getDrawable(R.color.dark));
        userButton.setBackground(getDrawable(R.color.dark));
        configButton.setBackground(getDrawable(R.color.dark));
        singInButton.setImageResource(R.drawable.ic_hora);
        userButton.setImageResource(R.drawable.ic_avatar);
        configButton.setImageResource(R.drawable.ic_global);
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
    private void startConfig() {
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment, configFragment);
        transaction.commit();
    }
}
