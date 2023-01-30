package com.example.dailytasks;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;

public class AddnewSession extends AppCompatActivity {
    TextView tv;
    Button b,bb1,bb2;
    Button b1,b2,b3;
    TimePicker tp;
    EditText et;
    int x = 1;
    String myList;
    TextClock tc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnew_session);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setCustomView(R.layout.attachbar);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        tv = findViewById(R.id.Date);
        b = findViewById(R.id.Add);
        b.setVisibility(View.GONE);
        tv.setText("Adding New Session");
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        tp = findViewById(R.id.timePicker);
        bb1 = findViewById(R.id.btngone);
        bb2 = findViewById(R.id.btngone2);
        et = findViewById(R.id.ET1);
        b3 = findViewById(R.id.button7);
        tc = findViewById(R.id.text_clock);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myList=et.getText().toString()+"  From: "+b1.getText().toString()+" To: "+b2.getText().toString();
                Intent j = new Intent();
                j.putExtra("array",myList);
                setResult(Activity.RESULT_OK,j);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tp.getVisibility()==View.GONE)
                {
                    tp.setVisibility(View.VISIBLE);
                    bb1.setVisibility(View.VISIBLE);
                }
            }
        });
        bb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String time = String.format("%d:%02d", tp.getCurrentHour(), tp.getCurrentMinute());
                b1.setText(time);
                bb1.setVisibility(View.GONE);
                tp.setVisibility(View.GONE);
            }
        });
        bb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String time = String.format("%d:%02d", tp.getCurrentHour(), tp.getCurrentMinute());
                b2.setText(time);
                bb2.setVisibility(View.GONE);
                tp.setVisibility(View.GONE);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tp.getVisibility()==View.GONE)
                {
                    tp.setVisibility(View.VISIBLE);
                    bb2.setVisibility(View.VISIBLE);
                }
            }
        });

    }
    @Override
    public void onBackPressed() {
        finish();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}