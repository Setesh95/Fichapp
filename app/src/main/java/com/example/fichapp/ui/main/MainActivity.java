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
import com.example.fichapp.ui.history.HistoryFragment;
import com.example.fichapp.ui.singing.SingInFragment;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel viewModel;
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentTransaction transaction;
    private SingInFragment singInFragment = new SingInFragment();
    private HistoryFragment historyFragment = new HistoryFragment();
    ImageButton singInButton, userButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new MainActivityViewModel();
        binding.setLifecycleOwner(this);
        binding.setViewModel(viewModel);
        singInButton = findViewById(R.id.sing_in_button);
        userButton = findViewById(R.id.user_button);
        setObservers();
    }

    private void setObservers(){
        viewModel.sign.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    singInButton.setImageResource(R.drawable.ic_hora_selected);
                    singInButton.setBackground(getDrawable(R.color.selectedNavButton));
                    startSingIn();
                } else {
                    singInButton.setImageResource(R.drawable.ic_hora);
                    singInButton.setBackground(getDrawable(R.color.dark));
                }
            }
        });
        viewModel.history.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean) {
                    userButton.setImageResource(R.drawable.ic_avatar_selected);
                    userButton.setBackground(getDrawable(R.color.selectedNavButton));
                    startHistory();
                } else {
                    userButton.setImageResource(R.drawable.ic_avatar);
                    userButton.setBackground(getDrawable(R.color.dark));
                }
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
