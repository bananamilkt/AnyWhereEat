package com.example.anywhereeat;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RestaurantRecyclerViewAdapter<RecyclerViewHolder> extends RecyclerView.Adapter<RestaurantRecyclerViewAdapter.RecyclerViewHolder> {
    Context context;
    ArrayList<Restaurant> restaurants;

    public RestaurantRecyclerViewAdapter(Context context, ArrayList<Restaurant> restaurants) {
        this.context = context;
        this.restaurants = restaurants;
    }

    @NonNull
    @Override
    public RestaurantRecyclerViewAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.restaurants_list_recycler_row, parent, false);

        return new RestaurantRecyclerViewAdapter.RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantRecyclerViewAdapter.RecyclerViewHolder holder, int position) {
        if(restaurants.get(position).getRestaurantName().equals("EMPTY")){
            holder.itemView.setVisibility(View.INVISIBLE);
        }else{
            holder.restaurantNameTextView.setText(restaurants.get(position).getRestaurantName());
            holder.restuarantLogo.setImageResource(restaurants.get(position).getLogo());
            holder.restaurantBackground.setImageResource(restaurants.get(position).getBackground());

            holder.restaurantCardClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, RestaurantPageActivity.class);
                    intent.putExtra("RestaurantInfo", restaurants.get(position));
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{

        TextView restaurantNameTextView;
        ImageView restuarantLogo;
        ImageView restaurantBackground;
        Button restaurantCardClick;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            restaurantNameTextView = itemView.findViewById(R.id.restaurantNameTextView);
            restuarantLogo = itemView.findViewById(R.id.restaurantLogoimageView);
            restaurantBackground = itemView.findViewById(R.id.restaurantBackgroundImageView);
            restaurantCardClick = itemView.findViewById(R.id.restaurantCard);
        }
    }
}
