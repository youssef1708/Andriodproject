package com.example.andriodproject;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper{

    private Context context;
    private static final String database_name = "Landmarks.db";
    private static final int database_version = 1;
    private static final String table_name = "landmarks";

    // 5 columns id, name, description, location, image
    private static final String column_id = "_id";
    private static final String column_name = "landmark_name";
    private static final String column_description = "landmark_description";
    private static final String column_location = "landmark_location";
    //private static final String column_image = "landmark_image";



    public DatabaseHelper(@Nullable Context context) {
        super(context, database_name, null, database_version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + table_name + " (" + column_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                column_name + " TEXT NOT NULL, "+ column_description + " Text NOT NULL, " +
                column_location + " Text NOT NULL);";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table_name);
        onCreate(db);

    }

    void add_landmark(String name, String description, String location){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(column_name, name);
        cv.put(column_description, description);
        cv.put(column_location, location);
        //cv.put(column_image, image);

        long result = db.insert(table_name, null, cv);
        if(result == -1){
            Toast.makeText(context, "Landmark addition failed.", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Landmark added successfully.", Toast.LENGTH_SHORT).show();

        }
    }

    Cursor read_all_data(){
        String query = "SELECT " + column_name  + "," + column_location + "," + column_description  + " From " + table_name;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }

        //Log.d("testttt", cursor.getString(1));
        return cursor;
    }
}
