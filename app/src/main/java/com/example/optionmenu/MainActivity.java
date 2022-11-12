package com.example.optionmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = (LinearLayout) findViewById(R.id.ll);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menucolors,menu);
        return true;
    }
     @SuppressLint("NonConstantResourceId")
     public void forColors(MenuItem item){
        switch (item.getItemId()){
            case R.id.clrRed:
                ll.setBackgroundColor(Color.RED);
                break;
            case R.id.clrBlue:
                ll.setBackgroundColor(Color.BLUE);
                break;
            case R.id.clrGreen:
                ll.setBackgroundColor(Color.GREEN);
                break;
            case R.id.clrCyan:
                ll.setBackgroundColor(Color.CYAN);
                break;
            case R.id.clrMagenta:
                ll.setBackgroundColor(Color.MAGENTA);
                break;
            case R.id.clrYellow:
                ll.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.clrPurple:
                ll.setBackgroundColor(getResources().getColor(android.R.color.holo_purple));
                break;
        }
     }
//
//    public void forMenu(MenuItem item){
//        Toast.makeText(getApplicationContext(),"OPTION MENU SELCTED",Toast.LENGTH_SHORT).show();
//    }
}