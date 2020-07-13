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
    Context activity;

    public DataAdapter(Context context, ArrayList<JobAdvert> list){
        jobAdverts = list;
        activity = context;

    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvAuthor, tvTitle;
        ImageView ivGenre;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            ivGenre = itemView.findViewById(R.id.ivGenre);


        }


    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder viewHolder, int index) {
        viewHolder.itemView.setTag(jobAdverts.get(index));

        viewHolder.tvTitle.setText(jobAdverts.get(index).getTitle());
        viewHolder.tvAuthor.setText(jobAdverts.get(index).getAuthor());

        if (jobAdverts.get(index).getGenre().equals("scifi")){
            viewHolder.ivGenre.setImageResource(R.drawable.scfi);
        } else if (jobAdverts.get(index).getGenre().equals("drama")) {
            viewHolder.ivGenre.setImageResource(R.drawable.drama);
        } else if (jobAdverts.get(index).getGenre().equals("romance")){
            viewHolder.ivGenre.setImageResource(R.drawable.romance);
        } else {
            viewHolder.ivGenre.setImageResource((R.drawable.images));
        }
    }

    @Override
    public int getItemCount() {
        return jobAdverts.size();
    }
}