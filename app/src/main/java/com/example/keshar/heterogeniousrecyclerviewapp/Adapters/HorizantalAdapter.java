package com.example.keshar.heterogeniousrecyclerviewapp.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.keshar.heterogeniousrecyclerviewapp.POJOs.HorizantalData;
import com.example.keshar.heterogeniousrecyclerviewapp.R;

import java.util.ArrayList;

public class HorizantalAdapter extends RecyclerView.Adapter<HorizantalAdapter.HorizantalViewHolder>{
    ArrayList<HorizantalData> horizantalData=new ArrayList<>();

    public HorizantalAdapter(ArrayList<HorizantalData> horizantalData) {
        this.horizantalData = horizantalData;
    }

    @NonNull
    @Override
    public HorizantalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizantal_item_layout,viewGroup,false);
        return new HorizantalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizantalViewHolder holder, int i) {
        HorizantalData data=horizantalData.get(i);
        holder.image.setImageResource(data.getImage());
        holder.name.setText(data.getName());
        holder.description.setText(data.getDescription());

    }

    @Override
    public int getItemCount() {
        return horizantalData.size();
    }

    public class HorizantalViewHolder extends RecyclerView.ViewHolder {
        TextView name,description;
        ImageView image;
        public HorizantalViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.imageView);
            name=itemView.findViewById(R.id.name);
            description=itemView.findViewById(R.id.description);
        }
    }

}
