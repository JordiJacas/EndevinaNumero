package com.example.tnb_20.endevinanumero;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    public class Record {
        public int intentos;
        public String nombre;

        public Record(String nombre, int intentos){
            this.nombre = nombre;
            this.intentos = intentos;
        }
    }

    ArrayList<Record> records = new ArrayList<Record>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        //String temp = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        int temp = intent.getIntExtra("int_value",0);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(Integer.toString(temp));
    }




}
