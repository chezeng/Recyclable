package com.example.tryrecycling;

import android.annotation.SuppressLint;
import android.location.Location;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclingStationAdapter extends RecyclerView.Adapter<RecyclingStationAdapter.ViewHolder> {

    private List<RecyclingStation> stationList;
    private List<RecyclingStation> filteredList;

    public RecyclingStationAdapter(List<RecyclingStation> stationList) {
        this.stationList = stationList;
        this.filteredList = new ArrayList<>(stationList);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycling_station_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RecyclingStation station = filteredList.get(position);
        holder.nameView.setText(station.getName());
        holder.addressView.setText(station.getAddress());
        holder.previewImageView.setImageResource(station.getImageResId());
        // Set preview image
        // holder.previewImageView.setImageDrawable(...);
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void filter(String term) {
        filteredList.clear();

        if (term.isEmpty()) {
            filteredList.addAll(stationList);
        } else {
            for (RecyclingStation station : stationList) {
                if (station.getName().toLowerCase().contains(term.toLowerCase()) ||
                        station.getAddress().toLowerCase().contains(term.toLowerCase())) {
                    filteredList.add(station);
                }
            }
        }

        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameView;
        public TextView addressView;
        public ImageView previewImageView;

        public ViewHolder(View view) {
            super(view);
            nameView = view.findViewById(R.id.name);
            addressView = view.findViewById(R.id.address);
            previewImageView = view.findViewById(R.id.preview_image);
        }
    }
}