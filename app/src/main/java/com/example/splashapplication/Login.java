package com.example.splashapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    TextView mEmail,mPassword;
    Button mLogin;
    TextView mTvRegi;
    ProgressBar progressBar2;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

//        mTvRegi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(Login.this,Register.class));
//            }
//        });

        mTvRegi = findViewById(R.id.tv_regi);
        mEmail=findViewById(R.id.emaillog);
        mPassword=findViewById(R.id.pass);
        mLogin=findViewById(R.id.btnLogin);
        progressBar2=findViewById(R.id.progressBar2);
        fAuth=FirebaseAuth.getInstance();
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String email=mEmail.getText().toString().trim();
                String password=mPassword.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mPassword.setError("password is required");
                    return;
                }
                if(password.length()<6){
                    mPassword.setError("password must contain atleast 6 characters");
                    return;
                }
                progressBar2.setVisibility(View.VISIBLE);
                //authenticate the user
                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Login.this, "logged in successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity2.class));
                        }else {
                            Toast.makeText(Login.this, "email or password error", Toast.LENGTH_SHORT).show();
                            progressBar2.setVisibility(View.GONE);
                        }
                    }
                });
            }


        });
        mTvRegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
                progressBar2.setVisibility(View.GONE);
            }
        });

    }
}