package com.example.fichapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.ImageButton;
import com.example.fichapp.R;
import com.example.fichapp.databinding.ActivityMainBinding;
import com.example.fichapp.ui.singing.SingInFragment;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel viewModel;
    private FragmentManager fragmentManager = getSupportFragmentManager();
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

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment, new SingInFragment(),"SingInFragment");
        transaction.commit();
    }
}
