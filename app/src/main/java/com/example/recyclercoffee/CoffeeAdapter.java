package com.example.recyclercoffee;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CoffeeAdapter extends RecyclerView.Adapter<CoffeeAdapter.CoffeeViewHolder> {

    private onCoffeeListener mOnCoffeeListener;

    public static class CoffeeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener { //имплементим он клик
        public TextView nameTextView;
        public TextView descrTextView;
        public ImageView photoImg;
        onCoffeeListener onCoffeeListener; //декларируем

        public CoffeeViewHolder(View itemView, onCoffeeListener onCoffeeListener) { //добавляем в констр
            super(itemView);
            nameTextView = itemView.findViewById(R.id.coffee_name);
            descrTextView = itemView.findViewById(R.id.coffee_description);
            photoImg = itemView.findViewById(R.id.coffee_photo);
            this.onCoffeeListener = onCoffeeListener;
            itemView.setOnClickListener(this); // крепим
        }

        @Override
        public void onClick(View v) {
            onCoffeeListener.onCoffeeClick(getAdapterPosition());//получаем позицию для метода в интерфейсе
        }
    }

    private List<Coffee> mCoffees;
    CoffeeAdapter(List<Coffee> coffees, onCoffeeListener onCoffeeListener) { //добавляем листенер
        mCoffees = coffees;
        mOnCoffeeListener = onCoffeeListener; //добавляем листенер
    }
    @NonNull
    @Override
    public CoffeeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) { //оздает новый объект ViewHolder всякий раз,
        // когда RecyclerView нуждается в этом. Это тот момент, когда создаётся layout строки списка, передается объекту ViewHolder,
        // и каждый дочерний view-компонент может быть найден и сохранен.
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rows_of_coffee, viewGroup, false);
        CoffeeViewHolder cvh = new CoffeeViewHolder(v,mOnCoffeeListener); //добавляем листенер
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeeViewHolder holder, int position) { //принимает объект ViewHolder и устанавливает необходимые данные для соответствующей строки во view-компоненте.
        holder.nameTextView.setText(mCoffees.get(position).name);
        holder.descrTextView.setText(mCoffees.get(position).description);
        holder.photoImg.setImageResource(mCoffees.get(position).imageResId);
    }

    @Override
    public int getItemCount() {
        return mCoffees.size();
    }
//для кликов 1е
    public interface onCoffeeListener {
        void onCoffeeClick(int position);
    }

}
