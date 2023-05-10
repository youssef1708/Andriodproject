package com.example.andriodproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;

    DatabaseHelper myDB;
    //ArrayList<String> landmark_name, landmark_location,landmark_info;
    ArrayList<LandmarkList> landmarkList = new ArrayList<>();
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Home");
        recyclerView = findViewById(R.id.recyclerview);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  Intent intent = new Intent(MainActivity.this,newAddLandmarkActivity.class);
                  startActivity(intent);
            }
        });
        Intent j = getIntent();
        String LandmarkName = j.getStringExtra("NewName");
        String LandmarkInfo = j.getStringExtra("NewInfo");
        String LandmarkLocation = j.getStringExtra("NewLocation");

        myDB = new DatabaseHelper(MainActivity.this);
        /*
        landmark_name = new ArrayList<>();
        landmark_location = new ArrayList<>();
        landmark_info = new ArrayList<>();

         */

        display_data();//store data in array

        customAdapter = new CustomAdapter(MainActivity.this, landmarkList);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


    }
/*
    void display_data(){
        Cursor cursor = myDB.read_all_data();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "No Data.", Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){
                landmark_name.add(cursor.getString(0));
                landmark_location.add(cursor.getString(1));
                landmark_info.add(cursor.getString(2));
            }
        }
         // testing
//        for (int i = 0; i < landmark_name.size(); i++) {
//            Log.d("testtttt", landmark_location.get(i));
//        }
    }

 */
    void display_data(){
        Cursor cursor = myDB.read_all_data();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                landmarkList.add(new LandmarkList(cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2)));
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);

        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //Toast.makeText(context,"Our word : "+s,Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                customAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


}