package com.example.midproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button signup = findViewById(R.id.btn_signup);
        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent activity_registration = new Intent(MainActivity.this, Registration.class);

                startActivity(activity_registration);
            }
        });

        Button loginhome = findViewById(R.id.btn_login);
        loginhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent activityhome = new Intent(MainActivity.this, homepage.class);
                startActivity(activityhome);
            }
        });
    }
}