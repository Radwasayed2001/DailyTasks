package com.example.dailytasks;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TextView Tdate;
    Button Badd;
    ListView l;
    ArrayList<String> myList = new ArrayList<String>();
    CheckBox c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setCustomView(R.layout.attachbar);
        actionBar.setDisplayShowCustomEnabled(true);
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE dd MMM yyyy");
        String date = sdf.format(currentDate);
        Tdate = findViewById(R.id.Date);
        Tdate.setText(date);
        Badd = findViewById(R.id.Add);
        Badd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,AddnewSession.class);
                startActivityForResult(i,100);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100&&resultCode==RESULT_OK)
        {
            String myList2=new String("");
            myList2 = data.getExtras().getString("array");
            c = new CheckBox(this);
            //c.setText(myList2);
            myList.add(myList2);
            l = findViewById(R.id.list);
            CheckboxArrayAdapter adapter = new CheckboxArrayAdapter(this, R.layout.style, myList);
            l.setAdapter(adapter);
        }
    }
}