package com.example.recyclerviewstudentdetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyStudentData[] myStudentData = new MyStudentData[]{
                new MyStudentData("Aditya","Patan",R.drawable.student_i,false),
                new MyStudentData("Krishna","Amreli",R.drawable.student_ii,false),
                new MyStudentData("Kinjal","Surendranager",R.drawable.student_iii,false),
                new MyStudentData("Dhruv","Dessa",R.drawable.student_iv,false),
        };

        MyStudentAdapter myStudentAdapter = new MyStudentAdapter(myStudentData,MainActivity.this);
        recyclerView.setAdapter(myStudentAdapter);
        myStudentAdapter.setOnItemClickListener(new MyStudentAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {


                myStudentAdapter.notifyItemRemoved(position);
            }
        });

    }
}