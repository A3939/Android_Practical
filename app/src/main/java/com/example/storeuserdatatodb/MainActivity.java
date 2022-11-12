package com.example.storeuserdatatodb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,mobile,Location;
    Button save,viewall;
    TextView output;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        mobile = findViewById(R.id.phoneNum);
        Location = findViewById(R.id.location);
        save = findViewById(R.id.save);
        viewall = findViewById(R.id.view);
        output = findViewById(R.id.display);

        db = new DatabaseHelper(MainActivity.this,"UserData",null,1);
        //save data
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String personName = name.getText().toString();
                String contact = mobile.getText().toString();
                String place = Location.getText().toString();

                long recordid = db.saveNewUserData(personName,contact,place);

                if(recordid > 0){
                    Toast.makeText(getApplicationContext(),"save successfully",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(),"save unsuccessfully",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //View all data
        viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String records = db.getAllRecords();
                output.setText(records);
            }
        });
    }
}