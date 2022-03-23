package com.example.modul3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MrHeadActivity extends AppCompatActivity implements View.OnClickListener  {
    ImageView ivBody, ivHair, ivEyebrow,ivEye, ivMoustache, ivBeard;
    CheckBox  cbRambut, cbjanggut, cbAlis, cbKumis;
    TextView greet;
    Button btContact;
    String email, password;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.mr_head_layout);

        this.ivBody = findViewById(R.id.ivBody);
        this.ivHair = findViewById(R.id.ivHair);
        this.ivEyebrow = findViewById(R.id.ivEyebrow);
        this.ivEye = findViewById(R.id.ivEyes);
        this.ivMoustache = findViewById(R.id.ivMustache);
        this.ivBeard = findViewById(R.id.ivBread);

        this.btContact = findViewById(R.id.contact);

        Intent intent = getIntent();
        email = intent.getStringExtra("email");
        password = intent.getStringExtra("password");

        this.greet = findViewById(R.id.greetings);
        greet.setText("Welcome, " + email +  "\n" + password );



        this.cbAlis = findViewById(R.id.cbAlis);
        this.cbjanggut = findViewById(R.id.cbJanggut);
        this.cbRambut = findViewById(R.id.cbRambut);
        this.cbKumis = findViewById(R.id.cbKumis);

        this.cbAlis.setChecked(true);
        this.cbjanggut.setChecked(true);
        this.cbKumis.setChecked(true);
        this.cbRambut.setChecked(true);

        this.cbAlis.setOnClickListener(this);
        this.cbjanggut.setOnClickListener(this);
        this.cbRambut.setOnClickListener(this);
        this.cbKumis.setOnClickListener(this);
        this.btContact.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        if(v.getId() == cbAlis.getId()) {
            if(cbAlis.isChecked())
                ivEyebrow.setVisibility(View.VISIBLE);
            else ivEyebrow.setVisibility(View.INVISIBLE);
        }
        if(v.getId() == cbjanggut.getId()){
            if(cbjanggut.isChecked())
                ivBeard.setVisibility(View.VISIBLE);
            else ivBeard.setVisibility(View.INVISIBLE);

        }
        if (v.getId() == cbRambut.getId()){
            if(cbRambut.isChecked())
                ivHair.setVisibility(View.VISIBLE);
            else
                ivHair.setVisibility(View.INVISIBLE);
        }
        if (v.getId() == cbKumis.getId()){
            if(cbKumis.isChecked())
                ivMoustache.setVisibility(View.VISIBLE);
            else
                ivMoustache.setVisibility(View.INVISIBLE);
        }
        if(v.getId() == btContact.getId()){
            Intent intentContact = new Intent(MrHeadActivity.this, ContactUsActivity.class);
            intentContact.putExtra("email", this.email);
            startActivity(intentContact);
        }
//
    }
}
