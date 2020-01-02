package com.example.recyclercoffee;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CoffeeAdapter extends RecyclerView.Adapter<CoffeeAdapter.CoffeeViewHolder> {

    public static class CoffeeViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView descrTextView;
        public ImageView photoImg;

        public CoffeeViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.coffee_name);
            descrTextView = itemView.findViewById(R.id.coffee_description);
            photoImg = itemView.findViewById(R.id.coffee_photo);
        }
    }

    private List<Coffee> mCoffees;
    CoffeeAdapter(List<Coffee> coffees) {
        mCoffees = coffees;
        
    }
    @NonNull
    @Override
    public CoffeeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rows_of_coffee, viewGroup, false);
        CoffeeViewHolder cvh = new CoffeeViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeeViewHolder holder, int position) {
        holder.nameTextView.setText(mCoffees.get(position).name);
        holder.descrTextView.setText(mCoffees.get(position).description);
        holder.photoImg.setImageResource(mCoffees.get(position).imageResId);
    }

    @Override
    public int getItemCount() {
        return mCoffees.size();
    }
}
