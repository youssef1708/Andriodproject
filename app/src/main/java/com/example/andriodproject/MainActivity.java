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
        Intent i = getIntent();
        String LandmarkName = i.getStringExtra("Name");
        String LandmarkInfo = i.getStringExtra("Info");
        String LandmarkLocation = i.getStringExtra("Location");
        ((TextView)findViewById(R.id.editTextTextPersonName)).setText(LandmarkName);
        ((TextView)findViewById(R.id.editTextTextPersonName2)).setText(LandmarkInfo);
        ((TextView)findViewById(R.id.editTextTextPersonName3)).setText(LandmarkLocation);

    }

    public void addLandmark(View v)
    {
        Intent i = new Intent(this,AddNewLandmarkActivity.class);
        startActivity(i);


    }
}