package com.example.splashapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    String title,content;
    int image;
    ImageView imageView;
    TextView textViewcontent;
    Button mbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        mbook=findViewById(R.id.booker);
        imageView = findViewById(R.id.imageView2);
        textViewcontent = findViewById(R.id.textViewContent);
        Bundle extras = getIntent().getExtras();
        if(extras == null) {
            title= null;
            image= 0;
        } else {
            title= extras.getString("title");
            content= extras.getString("content");
            image= extras.getInt("image");
            imageView.setImageResource(image);
            textViewcontent.setText(content);
        }
        mbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),BookActivity.class));
            }
        });
    }
}