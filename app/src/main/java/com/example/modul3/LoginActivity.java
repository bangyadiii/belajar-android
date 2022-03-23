package com.example.modul3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button btLogin;
    EditText etEmail, etPassword;
    String _email, _password;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.login_modul_3);
        btLogin = findViewById(R.id.btLogin);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        _email = "Triadi@gmail.com";
        _password = "205150700111037";

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                if (email.isEmpty() || password.isEmpty())
                    Toast.makeText(LoginActivity.this, "Email dan password tidak boleh kosong", Toast.LENGTH_SHORT).show();


                else if  (!email.equalsIgnoreCase(_email))
                    Toast.makeText(LoginActivity.this, "Username salah", Toast.LENGTH_SHORT).show();
                else if (!password.equalsIgnoreCase(_password))
                    Toast.makeText(LoginActivity.this, "password salah", Toast.LENGTH_SHORT).show();

                else{

                    Intent mrHead  = new Intent(LoginActivity.this, MrHeadActivity.class);
                    Bundle data = new Bundle();
                    data.putString("email", email);
                    data.putString("password", password);

                    mrHead.putExtras(data);
                    startActivity(mrHead);

                }
            }
        });


    }
}
