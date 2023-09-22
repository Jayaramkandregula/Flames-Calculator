package com.jayaram12.flamescalculator;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ConcurrentModificationException;
import java.util.List;

public class FlamesRecyclerViewAdapter extends RecyclerView.Adapter<FlamesRecyclerViewAdapter.ViewHolder> {
    private List<flames_class> flames_list;
    private Context context;

    public FlamesRecyclerViewAdapter(List<flames_class> flames_list, Context context) {
        this.flames_list = flames_list;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.flames_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        flames_class flames=flames_list.get(position);

        holder.p1_name.setText(flames.getP1_name());
        holder.p2_name.setText(flames.getP2_name());
        holder.flames_result.setText(flames.getFlames_result());
        holder.flames_result_image.setImageResource(flames.getImg_id());
    }

    @Override
    public int getItemCount() {
        return flames_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView p1_name,p2_name,flames_result;
        public ImageView flames_result_image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            p1_name=itemView.findViewById(R.id.text_p1_name);
            p2_name=itemView.findViewById(R.id.text_p2_name);
            flames_result=itemView.findViewById(R.id.flames_res);
            flames_result_image=itemView.findViewById(R.id.flames_res_image);
        }
    }
}
