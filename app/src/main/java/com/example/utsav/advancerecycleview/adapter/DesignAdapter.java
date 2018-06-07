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

import java.util.ArrayList;

public class DesignAdapter extends RecyclerView.Adapter<DesignAdapter.DesignViewHolder> {
    private Context context;
    private ArrayList<Design> designArrayList = new ArrayList<>();

    private DesignListener designListener;


    public DesignAdapter(Context context, ArrayList<Design> designArrayList, DesignListener designListener) {
        this.context = context;
        this.designArrayList = designArrayList;
        this.designListener = designListener;
    }

    @NonNull
    @Override
    public DesignViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_common, parent, false);
        return new DesignViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final DesignViewHolder holder, int position) {

        final Design design = designArrayList.get(position);
        if (design.isDesign()){
            holder.imageViewTick.setVisibility(View.VISIBLE);
        }else {
            holder.imageViewTick.setVisibility(View.GONE);
        }
        Glide.with(context).load(design.getImage()).into(holder.imageViewPhoto);
        holder.imageViewPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.imageViewTick.setVisibility(View.VISIBLE);
                designListener.onDesignClicked(design, holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return designArrayList.size();
    }

    public class DesignViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewPhoto, imageViewTick;

        public DesignViewHolder(View itemView) {
            super(itemView);
            imageViewPhoto = itemView.findViewById(R.id.ivData);
            imageViewTick = itemView.findViewById(R.id.visible);
        }
    }

    public interface DesignListener {
        void onDesignClicked(Design post, int position);
    }
}
