package com.example.andriodproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class viewLandmark extends AppCompatActivity {

    TextView  landmark_Name,landmark_info,landmark_Location;
    String Name,Info,Location;

    FloatingActionButton get_Location;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("View Landmark");
        setContentView(R.layout.activity_view_landmark);
        landmark_Name=findViewById(R.id.nameView);
        landmark_info=findViewById(R.id.infoView);
        landmark_Location=findViewById(R.id.LocationView);
        //get_Location=findViewById(R.id.buttonL);
        Button map = (Button) findViewById(R.id.buttonL);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 0,0?q="+ Name +""));
                in.setPackage("com.google.android.apps.maps");
                startActivity(in);





            }
        });

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