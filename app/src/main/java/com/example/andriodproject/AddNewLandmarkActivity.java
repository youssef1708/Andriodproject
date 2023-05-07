package com.example.andriodproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddNewLandmarkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_landmark);
        setTitle("Add New Landmark");

    }

    public void saveNewLandmark(View v)
    {
//        //Intent i = new Intent(this,MainActivity.class);
//        String landmarkName = ((EditText)findViewById(R.id.landmarkName)).getText().toString();
//        //i.putExtra("Name",landmarkName);
//        String landmarkInfo = ((EditText)findViewById(R.id.landmarkInfo)).getText().toString();
//        //i.putExtra("Info",landmarkInfo);
//        String landmarkLocation = ((EditText)findViewById(R.id.landmarkLocation)).getText().toString();
//        //i.putExtra("Location",landmarkLocation);
//        //startActivity(i);
    }

}