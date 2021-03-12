package com.example.splashapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    EditText mnames,memail,midno,mpassword;
    Button mRegisterbtn;
    TextView mLogin;
    ProgressBar progressBar;
    FirebaseAuth fAuth;
//    TextView mTvLog;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mnames=findViewById(R.id.name);
        memail=findViewById(R.id.email);
        midno=findViewById(R.id.identification);
        mpassword=findViewById(R.id.password);
        mRegisterbtn=findViewById(R.id.btnRegister);
        mLogin=findViewById(R.id.tv_logo);
        fAuth=FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progressBar);
       /* if (fAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),MainActivity2.class));
            finish();

        }

        */
        mRegisterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=mnames.getText().toString().trim();
                String email=memail.getText().toString().trim();
                String idno=midno.getText().toString().trim();
                String password=mpassword.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    memail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mpassword.setError("password is required");
                    return;
                }
                if(password.length()<6){
                    mpassword.setError("password must contain atleast 6 characters");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                //register user in FB




            }
        });




//        mTvLog.findViewById(R.id.tv_logo);

        btnRegister = findViewById(R.id.btnRegister);


//        mTvLog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Register.this,Login.class);
//                startActivity(intent);
//            }
//        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=memail.getText().toString().trim();
                
                String password=mpassword.getText().toString().trim();
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "user created!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity2.class));
                        }
                        else {
                            Toast.makeText(RegisterActivity.this, "user unsuccessfully registered!" +task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }

                    }
                });
            }
        });
    }
}