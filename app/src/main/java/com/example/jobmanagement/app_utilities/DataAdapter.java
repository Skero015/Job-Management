package com.example.jobmanagement.app_utilities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jobmanagement.R;
import com.example.jobmanagement.data_models.JobAdvert;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private ArrayList<JobAdvert> jobAdverts;
    ItemClicked activity;

    public interface ItemClicked
    {
        void  onItemClicked(int index);
    }

    public DataAdapter(Context context, ArrayList<JobAdvert> list){
        jobAdverts = list;
        activity = (ItemClicked)context;

    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvAuthor, tvTitle;
        ImageView ivGenre;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);


        }


    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder viewHolder, int index) {
        viewHolder.itemView.setTag(jobAdverts.get(index));


    }

    @Override
    public int getItemCount() {
        return jobAdverts.size();
    }
}