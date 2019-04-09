package com.example.keshar.heterogeniousrecyclerviewapp.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.keshar.heterogeniousrecyclerviewapp.POJOs.BottomData;
import com.example.keshar.heterogeniousrecyclerviewapp.R;

import java.util.ArrayList;

public class BottomAdapter extends RecyclerView.Adapter<BottomAdapter.BottomViewHolder>{
    ArrayList<BottomData> bottomData=new ArrayList<>();

    public BottomAdapter(ArrayList<BottomData> bottomData) {
        this.bottomData = bottomData;
    }

    @NonNull
    @Override
    public BottomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bottom_item_layout,viewGroup,false);
        return new BottomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BottomViewHolder bottomViewHolder, int i) {
        BottomData data=bottomData.get(i);
        bottomViewHolder.image.setImageResource(data.getImage());
        bottomViewHolder.name.setText(data.getName());
        bottomViewHolder.description.setText(data.getDescription());

    }

    @Override
    public int getItemCount() {
        return bottomData.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    public class BottomViewHolder extends RecyclerView.ViewHolder {
        TextView name,description;
        ImageView image;
        public BottomViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            description=itemView.findViewById(R.id.description);
            image=itemView.findViewById(R.id.profile);
        }
    }

}
