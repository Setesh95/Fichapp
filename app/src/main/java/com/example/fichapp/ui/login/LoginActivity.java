package com.example.fichapp.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import com.example.fichapp.R;
import com.example.fichapp.databinding.LoginActivityBinding;
import com.example.fichapp.ui.main.MainActivity;
import com.example.fichapp.ui.registry.RegisterActivity;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    private EditText emailInput, passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LoginActivityBinding binding = DataBindingUtil.setContentView(this,R.layout.login_activity);

        loginViewModel = new LoginViewModel(this);
        binding.setLifecycleOwner(this);
        binding.setViewModel(loginViewModel);

        ImageButton registerButton = findViewById(R.id.register);
        Button loginButton = findViewById(R.id.login_button);
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRegisterActivity();
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkValues();
            }
        });
    }
    private void startRegisterActivity(){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
    private void checkValues(){
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();
        if (loginViewModel.loginActionButton(email,password)){
            launchApp();
        }
    }

    private void launchApp(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
