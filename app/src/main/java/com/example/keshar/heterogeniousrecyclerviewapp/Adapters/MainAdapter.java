package com.example.keshar.heterogeniousrecyclerviewapp.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.keshar.heterogeniousrecyclerviewapp.POJOs.BottomData;
import com.example.keshar.heterogeniousrecyclerviewapp.POJOs.HorizantalData;
import com.example.keshar.heterogeniousrecyclerviewapp.POJOs.TopData;
import com.example.keshar.heterogeniousrecyclerviewapp.R;

import java.util.ArrayList;

import static com.example.keshar.heterogeniousrecyclerviewapp.MainActivity.getBottomData;
import static com.example.keshar.heterogeniousrecyclerviewapp.MainActivity.getHorizantalData;
import static com.example.keshar.heterogeniousrecyclerviewapp.MainActivity.getTopData;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Object> item;
    private Context context;
    private final int TOP = 1;
    private final int BOTTOM = 2;
    private final int HORIZANTAL = 3;

    public MainAdapter(ArrayList<Object> item, Context context) {
        this.item = item;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view;
        RecyclerView.ViewHolder holder;
        switch (viewType) {
            case TOP:
                view = inflater.inflate(R.layout.top_layout, viewGroup, false);
                holder = new TopViewHolder(view);
                break;
            case BOTTOM:
                view = inflater.inflate(R.layout.bottom_layout, viewGroup, false);
                holder = new BottomViewHolder(view);
                break;
            case HORIZANTAL:
                view = inflater.inflate(R.layout.horizantal_layout, viewGroup, false);
                holder = new HorizantalViewHolder(view);
                break;
            default:
                view = inflater.inflate(R.layout.horizantal_layout, viewGroup, false);
                holder = new HorizantalViewHolder(view);
                break;

        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {
        if(holder.getItemViewType()==TOP){
            topView((TopViewHolder) holder);
        }
        else if(holder.getItemViewType()==BOTTOM)
            bottomView((BottomViewHolder) holder);
        else if(holder.getItemViewType()==HORIZANTAL)
            horizantalView((HorizantalViewHolder) holder);

    }

    private void horizantalView(HorizantalViewHolder holder) {
        HorizantalAdapter horizantalAdapter=new HorizantalAdapter(getHorizantalData());
        holder.recyclerView.setAdapter(horizantalAdapter);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));

    }

    private void bottomView(BottomViewHolder holder) {
        BottomAdapter bottomAdapter=new BottomAdapter(getBottomData());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        holder.recyclerView.setAdapter(bottomAdapter);
    }

    private void topView(TopViewHolder holder) {
        TopAdapter topAdapter=new TopAdapter(getTopData());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        holder.recyclerView.setAdapter(topAdapter);
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(item.get(position) instanceof HorizantalData)
            return HORIZANTAL;
        else if(item.get(position) instanceof TopData)
            return TOP;
        else if(item.get(position) instanceof BottomData)
            return BOTTOM;
        return -1;
    }

    public class TopViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        public TopViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView=itemView.findViewById(R.id.recyclerview);
        }
    }

    public class BottomViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        public BottomViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView=itemView.findViewById(R.id.recyclerview);
        }
    }

    public class HorizantalViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        public HorizantalViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView=itemView.findViewById(R.id.recyclerview);
        }
    }

}
