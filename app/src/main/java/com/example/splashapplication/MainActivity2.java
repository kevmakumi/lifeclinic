package com.example.splashapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    CardView Dental,Optical,Pharmacy,Maternal;
    TextView mTvLogin,mtvRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();
        Dental=findViewById(R.id.image2);
        mtvRegister=findViewById(R.id.tv_register);
        Dental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(MainActivity2.this,Dental.class));
            }
        });
        Optical=findViewById(R.id.Optical);
        Optical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this, OpticalActivity.class));
            }
        });
        Pharmacy=findViewById(R.id.Pharmacy);
        Pharmacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this, PharmacyActivity.class));
            }
        });
        Maternal=findViewById(R.id.Maternal);
        Maternal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this,Maternal.class));
            }
        });


        mTvLogin=findViewById(R.id.tv_login);
        mTvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity2.this,Login.class));

            }
        });




       mtvRegister.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
           }
       });
    }
}