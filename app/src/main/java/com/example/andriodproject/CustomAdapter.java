package com.example.andriodproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> implements Filterable {

    private Context context;
    //private ArrayList landmark_name,landmark_info, landmark_location;

    private List<LandmarkList> landmarkList = new ArrayList<>();
    private List<LandmarkList> landmarkListAll = new ArrayList<>();



    CustomAdapter(Context context, ArrayList<LandmarkList> landmarkList){
        this.context = context;
        /*
        this.landmark_name = landmark_name;
        this.landmark_location = landmark_location;
        this.landmark_info = landmark_info; */
        this.landmarkList = landmarkList;
        this.landmarkListAll= new ArrayList<>(landmarkList);


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

        /*
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

         */
        LandmarkList llist = landmarkList.get(position2);
        holder.landmark_name_txt.setText(String.valueOf(llist.getLandmark_name()));
        holder.landmark_info_txt.setText(String.valueOf(llist.getLandmark_info()));
        holder.landmark_location_txt.setText(String.valueOf(llist.getLandmark_location()));

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, viewLandmark.class);
                intent.putExtra("Name",String.valueOf(llist.getLandmark_name()));
                intent.putExtra("Info",String.valueOf(llist.getLandmark_info()));
                intent.putExtra("Location",String.valueOf(llist.getLandmark_location()));
                context.startActivity(intent);
            }
        });

    }
    @Override
    public int getItemCount() {
        return landmarkList.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }
    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constaint)
        {

            List<LandmarkList> filteredList = new ArrayList<>();
            if (constaint.toString().isEmpty()) {
                filteredList.addAll(landmarkListAll);
            }else
            {
                for(LandmarkList landmark : landmarkListAll)
                {
                    if (landmark.getLandmark_name().toLowerCase().contains(constaint.toString().toLowerCase())
                            || landmark.getLandmark_location().toLowerCase().contains(constaint.toString().toLowerCase())) {
                        filteredList.add(landmark);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults filterResults) {
            landmarkList.clear();
            landmarkList.addAll((Collection<? extends LandmarkList>) filterResults.values);
            notifyDataSetChanged();

        }
    };

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
