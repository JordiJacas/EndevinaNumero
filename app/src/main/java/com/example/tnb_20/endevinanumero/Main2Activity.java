package com.example.tnb_20.endevinanumero;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

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

        //alertView("Hello");
    }

    private void alertView( String message ) {
        Dialog dialog = new Dialog(getApplication());
        dialog.setTitle( "Hello" );
        dialog.setContentView(R.layout.layout_dialog);
        dialog.show();
    }


}
