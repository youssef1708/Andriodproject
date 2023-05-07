package com.example.andriodproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class newAddLandmarkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_add_landmark);
        setTitle("Add New Landmark");

    }

    public void NewSave(View vi)
    {
        Intent j = new Intent(this,MainActivity.class);
        String landmarkName = ((TextInputLayout)findViewById(R.id.textInputLayout)).getEditText().getText().toString();
        j.putExtra("NewName",landmarkName);
        String landmarkInfo = ((TextInputLayout)findViewById(R.id.textInputLayout2)).getEditText().getText().toString();
        j.putExtra("NewInfo",landmarkInfo);
        String landmarkLocation = ((TextInputLayout)findViewById(R.id.textInputLayout3)).getEditText().getText().toString();
        j.putExtra("NewLocation",landmarkLocation);
        startActivity(j);
    }
    public void Cancel(View v)
    {
        Intent f = new Intent(this,MainActivity.class);
        startActivity(f);
    }
}