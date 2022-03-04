package com.example.numad22sp_zhaoyangwang;

import java.util.*;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

public class RecyclViewAdapter extends RecyclerView.Adapter<RecyclViewAdapter.MyViewHolder> {

    List<Item> itemList;
    Context context;

    public RecyclViewAdapter(List<Item> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lc_one_line_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.item_url.setText(itemList.get(position).getUrl());
        holder.item_name.setText(itemList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView item_url;
        TextView item_name;
        ConstraintLayout linkCollectorMainPage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item_url = itemView.findViewById(R.id.lc_url);
            item_name = itemView.findViewById(R.id.lc_name);
            linkCollectorMainPage = itemView.findViewById(R.id.LinkCollectorMainPage);
            item_url.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String website = item_url.getText().toString();
                    try {
                        Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
                        context.startActivity(browse);
                    } catch (Exception e) {
                        System.out.println("Invalid URL");

                    }

                }
            });

        }
    }
}
