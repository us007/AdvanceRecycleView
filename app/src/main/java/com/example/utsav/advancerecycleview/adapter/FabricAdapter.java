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
import com.example.utsav.advancerecycleview.model.Design;
import com.example.utsav.advancerecycleview.model.Fabric;

import java.util.ArrayList;

public class FabricAdapter extends RecyclerView.Adapter<FabricAdapter.FabricViewHolder> {
    private Context context;
    private ArrayList<Fabric> fabricArrayList = new ArrayList<>();
    private FabricListener listener;

    public FabricAdapter(Context context, ArrayList<Fabric> fabricArrayList, FabricListener listener) {
        this.context = context;
        this.fabricArrayList = fabricArrayList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public FabricViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_common, parent, false);

        return new FabricViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FabricViewHolder holder, int position) {
        final Fabric fabric = fabricArrayList.get(position);
        if (fabric.isFabric()) {
            holder.imageViewTick.setVisibility(View.VISIBLE);
        } else {
            holder.imageViewTick.setVisibility(View.GONE);
        }
        fabricArrayList.get(position).setPosition(position);
        Glide.with(context).load(fabric.getImage()).into(holder.imageViewPhoto);
        holder.imageViewPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.imageViewTick.setVisibility(View.VISIBLE);
                listener.onFabricClicked(fabric, holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return fabricArrayList.size();
    }

    public class FabricViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewPhoto, imageViewTick;

        public FabricViewHolder(View itemView) {
            super(itemView);
            imageViewPhoto = itemView.findViewById(R.id.ivData);
            imageViewTick = itemView.findViewById(R.id.visible);
        }
    }

    public interface FabricListener {
        void onFabricClicked(Fabric post, int position);
    }
}
