package com.example.andriodproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{

    private Context context;
    private ArrayList landmark_name,landmark_info, landmark_location;



    CustomAdapter(Context context, ArrayList landmark_name, ArrayList landmark_info,ArrayList landmark_location){
        this.context = context;
        this.landmark_name = landmark_name;
        this.landmark_location = landmark_location;
        this.landmark_info = landmark_info;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,int position2) {

        holder.landmark_name_txt.setText(String.valueOf(landmark_name.get(position2)));
        //holder.landmark_info_txt.setText(String.valueOf(landmark_info.get(position2)));
        holder.landmark_location_txt.setText(String.valueOf(landmark_location.get(position2)));
        holder.mainLayout.setOnClickListener(view -> {
            Intent intent = new Intent(context,viewLandmark.class);
            intent.putExtra("Name",String.valueOf(landmark_name.get(position2)));
            intent.putExtra("Info",String.valueOf(landmark_info.get(position2)));
            intent.putExtra("Location",String.valueOf(landmark_location.get(position2)));

            context.startActivity(intent);


        });

    }

    @Override
    public int getItemCount() {
        return landmark_name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView landmark_name_txt, landmark_location_txt,landmark_info_txt ;
        LinearLayout mainLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            landmark_name_txt = itemView.findViewById(R.id.landmark_name);
            landmark_location_txt = itemView.findViewById(R.id.landmark_location);
            landmark_info_txt = itemView.findViewById(R.id.landmark_info);
            mainLayout = itemView.findViewById(R.id.mainLayout);

        }
    }
}
