package com.example.andriodproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Home");
        Intent j = getIntent();
        String LandmarkName = j.getStringExtra("NewName");
        String LandmarkInfo = j.getStringExtra("NewInfo");
        String LandmarkLocation = j.getStringExtra("NewLocation");
        ((TextView)findViewById(R.id.editTextTextPersonName)).setText(LandmarkName);
        ((TextView)findViewById(R.id.editTextTextPersonName2)).setText(LandmarkInfo);
        ((TextView)findViewById(R.id.editTextTextPersonName3)).setText(LandmarkLocation);

    }

    public void addLandmark(View v)
    {
        Intent i = new Intent(this,newAddLandmarkActivity.class);
        startActivity(i);


    }
}