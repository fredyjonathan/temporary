package com.example.midproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        TextView ncar, dcar, nmc, dmc;
        ImageView icar, imc;

        icar = (ImageView)findViewById(R.id.imgcar);
        ncar = (TextView)findViewById(R.id.namecar);
        dcar = (TextView)findViewById(R.id.dtlcar);
        imc = (ImageView)findViewById(R.id.imgmc);
        nmc = (TextView)findViewById(R.id.namemc);
        dmc = (TextView)findViewById(R.id.dtlmc);

        Button lcar = findViewById(R.id.btncar1);
        lcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icar.setVisibility(View.VISIBLE);
                ncar.setVisibility(View.VISIBLE);
                dcar.setVisibility(View.VISIBLE);
                imc.setVisibility(View.GONE);
                nmc.setVisibility(View.GONE);
                dmc.setVisibility(View.GONE);
            }
        });

        Button lmc = findViewById(R.id.btnmc1);
        lmc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icar.setVisibility(View.GONE);
                ncar.setVisibility(View.GONE);
                dcar.setVisibility(View.GONE);
                imc.setVisibility(View.VISIBLE);
                nmc.setVisibility(View.VISIBLE);
                dmc.setVisibility(View.VISIBLE);
            }
        });

        Button test = findViewById(R.id.btntest);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent testpage = new Intent(homepage.this, Home.class);
                startActivity(testpage);
            }
        });
    }
}