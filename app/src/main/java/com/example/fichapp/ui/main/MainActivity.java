package com.example.fichapp.ui.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.MenuItem;
import com.example.fichapp.R;
import com.example.fichapp.databinding.ActivityMainBinding;
import com.example.fichapp.ui.Navigator;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        BottomNavigationView.OnNavigationItemSelectedListener {

    private MainActivityViewModel viewModel;
    private BottomNavigationView navigation;
    private Navigator navigator = Navigator.getInstance(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_main);
        viewModel = new MainActivityViewModel();
        navigation = binding.getRoot().findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        navigation.setSelectedItemId(R.id.register_control_menu);
        binding.setLifecycleOwner(this);
        binding.setViewModel(viewModel);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId() != navigation.getSelectedItemId()){
            navigator.navigateMenu(menuItem.getItemId(), false);
        }
        return true;
    }
}
