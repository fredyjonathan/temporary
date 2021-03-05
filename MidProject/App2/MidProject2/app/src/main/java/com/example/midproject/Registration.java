package com.example.midproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        Button login = findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent activity_login = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(activity_login);
            }
        });

        Button signuphome = findViewById(R.id.btn_signup);
        signuphome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent activityhome = new Intent(Registration.this, homepage.class);
                startActivity(activityhome);
            }
        });
    }
}