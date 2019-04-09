package com.example.keshar.heterogeniousrecyclerviewapp.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.keshar.heterogeniousrecyclerviewapp.POJOs.TopData;
import com.example.keshar.heterogeniousrecyclerviewapp.R;

import java.util.ArrayList;

public class TopAdapter extends RecyclerView.Adapter<TopAdapter.TopViewHolder>{

    ArrayList<TopData> topData=new ArrayList<>();

    public TopAdapter(ArrayList<TopData> topData) {
        this.topData = topData;
    }

    @NonNull
    @Override
    public TopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.top_item_layout,parent,false);
        return new TopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopViewHolder holder, int i) {
        TopData data=topData.get(i);
        holder.title.setText(data.getTitle());
        holder.description.setText(data.getDescription());


    }

    @Override
    public int getItemCount() {
        return topData.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public class TopViewHolder extends RecyclerView.ViewHolder {
        TextView title,description;
        public TopViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            description=itemView.findViewById(R.id.description);
        }
    }

}
