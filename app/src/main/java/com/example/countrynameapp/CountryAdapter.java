package com.example.countrynameapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.countrynameapp.model.CountryModel;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    private ArrayList<CountryModel> countryModels;

    public CountryAdapter(ArrayList<CountryModel> countryModels) {
        this.countryModels = countryModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.countryName.setText(countryModels.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return countryModels.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView countryName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            countryName = itemView.findViewById(R.id.countryName);
        }
    }
}
