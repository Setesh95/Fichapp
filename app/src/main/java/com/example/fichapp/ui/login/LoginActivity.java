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
import com.example.fichapp.ui.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoginActivityBinding binding = DataBindingUtil.setContentView(this,R.layout.login_activity);
        loginViewModel = new LoginViewModel();
        binding.setLifecycleOwner(this);
        binding.setLoginViewModel(loginViewModel);
        ImageButton registerButton = findViewById(R.id.register);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRegisterActivity();
            }
        });
        final Button loginButton = findViewById(R.id.login_button);
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
        EditText email = findViewById(R.id.emailInput);
        EditText password = findViewById(R.id.passwordInput);
        if(email.getText().toString().contains("@") && !password.getText().toString().isEmpty()){
            loginViewModel.loginButtonAction(email.getText().toString(),password.getText().toString());
        }
    }
}
