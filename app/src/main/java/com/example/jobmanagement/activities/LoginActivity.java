package com.example.jobmanagement.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jobmanagement.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    Button btnRegister,btnLogin;
    TextInputEditText etPassword,etEmail;
    TextInputLayout txtPassword,txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegister = findViewById(R.id.btnRegisterMain);
        btnLogin = findViewById(R.id.btnLoginMain);
        etPassword = findViewById(R.id.etPasswordLogin);
        txtPassword= findViewById(R.id.txtPassLogin);
        txtEmail = findViewById(R.id.txtEmailLogin);
        etEmail = findViewById(R.id.etEmailLogin);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, JobAdvertActivity.class);
                startActivity(intent);
            }
        });
    }
}
