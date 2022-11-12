package com.example.recyclerviewstudentdetail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyStudentAdapter extends RecyclerView.Adapter<MyStudentAdapter.ViewHolder>{

    MyStudentData[] myStudentData;
    private OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener clickListener){
        listener = clickListener;
    }

    Context context;
    public MyStudentAdapter(MyStudentData[] myStudentData, MainActivity activity){
        this.myStudentData = myStudentData;
        this.context =activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.student_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view,listener);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final MyStudentData myStudentDataList = myStudentData[position];
        holder.textViewName.setText(myStudentDataList.getStuName());
        holder.textViewAdd.setText(myStudentDataList.getStuAdd());
        holder.stuImg.setImageResource (myStudentDataList.getStuImg());


        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(context, myStudentDataList.getStuName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return myStudentData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView stuImg;
        TextView textViewName;
        TextView textViewAdd;
        ImageView delete;
        public ViewHolder(@NonNull View itemView, OnItemClickListener listener){
            super(itemView);
            stuImg = itemView.findViewById(R.id.imageView);
            textViewName = itemView.findViewById(R.id.textName);
            textViewAdd = itemView.findViewById(R.id.textAdd);
            delete = itemView.findViewById(R.id.delete_id);

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(getAdapterPosition());
                }
            });
        }

    }
}
