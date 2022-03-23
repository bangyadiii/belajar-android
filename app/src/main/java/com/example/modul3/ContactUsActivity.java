package com.example.modul3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ContactUsActivity extends AppCompatActivity {
    Intent intentMrHead;
    Button btEmail, btTelpon, btSMS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        this.btEmail = findViewById(R.id.btEmail);
        this.btTelpon = findViewById(R.id.btTelpon);
        this.btSMS = findViewById(R.id.btSMS);

        this.intentMrHead = getIntent();

        btEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentEmail = new Intent(Intent.ACTION_SEND);
                intentEmail.setDataAndType(Uri.parse("mailto:"), "message/rfc822");
                String[] to = {"triadi@gmail.com"};
                intentEmail.putExtra(Intent.EXTRA_EMAIL, to);
                intentEmail.putExtra(Intent.EXTRA_SUBJECT, "testing");
                intentEmail.putExtra(Intent.EXTRA_TEXT, "Hello Mr Head, Do you want to date with me?");

                if (intentEmail.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentEmail);
                }

            }
        });

        btTelpon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intentTelp = new Intent(Intent.ACTION_DIAL);
                    intentTelp.setData(Uri.parse("tel:+6289696508086"));
                    startActivity(intentTelp);
                }

                catch (android.content.ActivityNotFoundException error){
                    Log.d("Error" , "Telpon Error : " + error);
                }

            }
        });

        btSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intentSMS = new Intent(Intent.ACTION_VIEW);
                    intentSMS.setData(Uri.parse("sms:+6289696508086"));
                    intentSMS.putExtra("sms_body", "Helo Mr Head, nice to meet you!");
                    startActivity(intentSMS);
                } catch (android.content.ActivityNotFoundException error) {
                    Log.d("Error" , "SMS Error : " + error);
                }

            }
        });
    }
}