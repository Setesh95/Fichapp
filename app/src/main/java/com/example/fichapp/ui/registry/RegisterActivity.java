package com.example.fichapp.ui.registry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
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
    EditText companyInput, emailInput, passwordInput, checkPasswordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final RegisterLayoutBinding binding = DataBindingUtil.setContentView(this, R.layout.register_layout);
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
        setObserver();
    }

    private void setObserver(){
        registerViewModel.response.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                switch (s){
                    case Constants.REGISTERED_SUCCESSFULLY :
                        showMessage("Registrado correctamente");
                        finish();
                        break;
                    case Constants.PASSWORD_NOT_MATCH :
                        showMessage("password must match");
                        break;
                    case Constants.PASSWORD_CONTAINS_SPACE:
                        showMessage("password can not contain space");
                        break;
                    case Constants.USER_ALREDY_REGISTERED:
                        showMessage("user alredy registered");
                        break;
                }
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

    private void showMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
