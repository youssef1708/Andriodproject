package com.example.andriodproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class viewLandmark extends AppCompatActivity {

    TextView  landmark_Name,landmark_info,landmark_Location;
    String Name,Info,Location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("View Landmark");
        setContentView(R.layout.activity_view_landmark);
        landmark_Name=findViewById(R.id.nameView);
        landmark_info=findViewById(R.id.infoView);
        landmark_Location=findViewById(R.id.LocationView);
        getIntentData();
    }

    void getIntentData(){
        if(getIntent().hasExtra("Name") && getIntent().hasExtra("Info")
                && getIntent().hasExtra("Location"))
        {
            Name=getIntent().getStringExtra("Name");
            Info=getIntent().getStringExtra("Info");
            Location=getIntent().getStringExtra("Location");
            landmark_Name.setText(Name);
            landmark_info.setText(Info);
            landmark_Location.setText(Location);


        }
        else
        {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }
}