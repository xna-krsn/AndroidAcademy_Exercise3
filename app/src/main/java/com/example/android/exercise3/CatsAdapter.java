package com.example.android.exercise3;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CatsAdapter extends RecyclerView.Adapter<CatsAdapter.CatHolder> {
    private final List<Cat> cats;
    private final OnItemClickListener clickListener;


    public CatsAdapter(List<Cat> cats, OnItemClickListener clickListener) {
        this.cats = cats;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public CatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View catView = inflater.inflate(R.layout.cat, parent, false);
        return new CatHolder(catView);
    }

    @Override
    public void onBindViewHolder(@NonNull CatHolder holder, int position) {
        final Cat cat = cats.get(position);
        holder.catName.setText(cat.getName());
        Picasso.get().load(cat.getPhotoUrl()).into(holder.catPhoto);

        holder.catView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clickListener != null) {
                    clickListener.onItemClick(cat);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return cats.size();
    }

    public interface OnItemClickListener {
        void onItemClick(@NonNull Cat cat);
    }

    static class CatHolder extends RecyclerView.ViewHolder {
        private final View catView;
        private final TextView catName;
        private final ImageView catPhoto;

        public CatHolder(View itemView) {
            super(itemView);
            catView = itemView;
            catName = itemView.findViewById(R.id.name);
            catPhoto = itemView.findViewById(R.id.photo);
        }
    }
}
