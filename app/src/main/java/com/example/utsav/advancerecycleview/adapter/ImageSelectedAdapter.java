package com.example.utsav.advancerecycleview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.utsav.advancerecycleview.R;
import com.example.utsav.advancerecycleview.model.Fabric;
import com.example.utsav.advancerecycleview.model.ImageSelected;

import java.util.ArrayList;

public class ImageSelectedAdapter extends RecyclerView.Adapter<ImageSelectedAdapter.ImageSelectedViewHolder> {
    private Context context;
    private ArrayList<ImageSelected> selectedArrayList = new ArrayList<>();

    public ImageSelectedAdapter(Context context, ArrayList<ImageSelected> selectedArrayList) {
        this.context = context;
        this.selectedArrayList = selectedArrayList;
    }

    @NonNull
    @Override
    public ImageSelectedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_selected_row, parent, false);

        return new ImageSelectedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageSelectedViewHolder holder, int position) {
        ImageSelected imageSelected = selectedArrayList.get(position);
        Glide.with(context).load(imageSelected.getImage()).into(holder.imageViewPhoto);
    }

    @Override
    public int getItemCount() {
        return selectedArrayList.size();
    }

    public class ImageSelectedViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewPhoto;

        public ImageSelectedViewHolder(View itemView) {
            super(itemView);
            imageViewPhoto = itemView.findViewById(R.id.ivSelected);
        }
    }
}
