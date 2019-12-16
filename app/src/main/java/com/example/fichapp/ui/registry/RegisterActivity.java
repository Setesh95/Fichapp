package com.example.fichapp.ui.registry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fichapp.R;
import com.example.fichapp.databinding.RegisterLayoutBinding;
import com.example.fichapp.repository.Constants;

public class RegisterActivity extends AppCompatActivity {

    private RegisterViewModel registerViewModel;
    EditText companyInput, emailInput, passwordInput, passwordRepeatInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final RegisterLayoutBinding binding = DataBindingUtil.setContentView(this, R.layout.register_layout);
        registerViewModel = new RegisterViewModel(getApplication());
        binding.setLifecycleOwner(this);
        binding.setViewModel(registerViewModel);
        companyInput = findViewById(R.id.company_input);
        emailInput = findViewById(R.id.email_input);
        passwordInput = findViewById(R.id.password_input);
        passwordRepeatInput = findViewById(R.id.password_repeat_input);
        Button registerButton = findViewById(R.id.register_button);
        registerButton.setOnClickListener(v -> registerAction());
        setObserver();
    }

    private void setObserver() {
        registerViewModel.response.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                switch (s) {
                    case Constants.REGISTERED_SUCCESSFULLY:
                        showMessage(Constants.REGISTERED_SUCCESSFULLY_MESSAGE);
                        finish();
                        break;
                    case Constants.PASSWORD_NOT_MATCH:
                        showMessage(Constants.PASSWORD_NOT_MATCH_MESSAGE);
                        break;
                    case Constants.PASSWORD_CONTAINS_SPACE:
                        showMessage(Constants.PASSWORD_CONTAINS_SPACE_MESSAGE);
                        break;
                    case Constants.EMAIL_ALREADY_REGISTERED:
                        showMessage(Constants.EMAIL_ALREADY_REGISTERED_MESSAGE);
                        break;
                }
            }
        });
    }

    private void registerAction() {
        String company = companyInput.getText().toString();
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();
        String passwordRepeat = passwordRepeatInput.getText().toString();
        registerViewModel.registerNewUser(company, email, password, passwordRepeat);
    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
