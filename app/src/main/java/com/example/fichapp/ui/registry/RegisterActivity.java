package com.example.fichapp.ui.registry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fichapp.R;
import com.example.fichapp.databinding.RegisterLayoutBinding;

public class RegisterActivity extends AppCompatActivity {

    private RegisterViewModel registerViewModel;
    EditText companyInput, emailInput, passwordInput, checkPasswordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RegisterLayoutBinding binding = DataBindingUtil.setContentView(this, R.layout.register_layout);
        registerViewModel = new RegisterViewModel(this);
        binding.setLifecycleOwner(this);
        binding.setViewModel(registerViewModel);
        companyInput = findViewById(R.id.companyInput);
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        checkPasswordInput = findViewById(R.id.checkPasswordInput);
        Button registerButton = findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerAction();
            }
        });
    }
    private void registerAction(){
        String company = companyInput.getText().toString();
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();
        String checkPassword = checkPasswordInput.getText().toString();
        registerViewModel.registerActionButton(company,email,password, checkPassword);
    }
}
