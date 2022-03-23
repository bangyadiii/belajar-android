package com.example.modul3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PracticeActivity extends AppCompatActivity {
    Button bt_login;
    EditText etEmail, etPassword;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.praktikum_login_modul);
        bt_login = findViewById(R.id.bt_login);

        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                if(email.isEmpty() || password.isEmpty())
                    Toast.makeText(PracticeActivity.this, "Email dan password tidak boleh kosong", Toast.LENGTH_SHORT).show();

                else if(email.equals("Tri adi") && password.equals("1234"))
                    Toast.makeText(PracticeActivity.this, "Berhasil login", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(PracticeActivity.this, "Username atau password salah", Toast.LENGTH_SHORT).show();

            }
        });


    }





}