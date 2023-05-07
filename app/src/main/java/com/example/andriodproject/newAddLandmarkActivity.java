package com.example.andriodproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class newAddLandmarkActivity extends AppCompatActivity {

    Button save_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_add_landmark);
        setTitle("Add New Landmark");

        save_button = findViewById(R.id.save_button);
        save_button.setOnClickListener(v -> {
            //try
            Intent j = new Intent(newAddLandmarkActivity.this,MainActivity.class);
            String landmarkName = ((TextInputLayout)findViewById(R.id.textInputLayout)).getEditText().getText().toString();
            j.putExtra("NewName",landmarkName);
            String landmarkDescription = ((TextInputLayout)findViewById(R.id.textInputLayout2)).getEditText().getText().toString();
            j.putExtra("NewInfo",landmarkDescription);
            String landmarkLocation = ((TextInputLayout)findViewById(R.id.textInputLayout3)).getEditText().getText().toString();
            j.putExtra("NewLocation",landmarkLocation);
            startActivity(j);

            DatabaseHelper myDB = new DatabaseHelper(newAddLandmarkActivity.this);
            myDB.add_landmark(landmarkName,landmarkDescription, landmarkLocation);
        });
    }


    public void Cancel(View v)
    {
        Intent f = new Intent(this,MainActivity.class);
        startActivity(f);
    }
}