package com.example.fichapp.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.fichapp.R;
import com.example.fichapp.databinding.LoginActivityBinding;
import com.example.fichapp.utils.Constants;
import com.example.fichapp.ui.registry.SignUpActivity;
import com.example.fichapp.ui.splash.LoadingActivity;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    private EditText emailInput, passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LoginActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.login_activity);

        loginViewModel = new LoginViewModel(getApplication());
        binding.setLifecycleOwner(this);
        binding.setViewModel(loginViewModel);
        ImageButton registerButton = findViewById(R.id.register_button);
        Button loginButton = findViewById(R.id.login_button);
        emailInput = findViewById(R.id.email_input);
        passwordInput = findViewById(R.id.password_input);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRegister();
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkValues();
            }
        });
        setObserver();
    }

    private void setObserver() {
        loginViewModel.response.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                switch (s) {
                    case Constants.LOGIN_SUCCESSFULLY:
                        launchApp();
                        break;
                    case Constants.WRONG_PASSWORD:
                        showMessage(Constants.WRONG_PASSWORD_MESSAGE);
                        break;
                    case Constants.USER_NOT_FOUND:
                        showMessage(Constants.USER_NOT_FOUND_MESSAGE);
                        break;
                }
            }
        });
    }

    private void startRegister() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    private void checkValues() {
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();
        loginViewModel.loginActionButton(email, password);
    }

    private void launchApp() {
        Intent intent = new Intent(this, LoadingActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
