package com.example.tnb_20.endevinanumero;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class Main2Activity extends AppCompatActivity {

    public recordtest o = new recordtest();
    public class Record implements Comparable<Record>{
        public int intentos;
        public String nombre;

        public Record(String nombre, int intentos){
            this.nombre = nombre;
            this.intentos = intentos;
        }

        public int compareTo(Record o){
            if(intentos < o.intentos){
                return -1;
            }
            if(intentos > o.intentos){
                return 1;
            }
            return 0;
        }
    }

    ArrayList<Record> records;
    ArrayAdapter<Record> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        //String temp = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        int intentos = intent.getIntExtra("int_value",0);
        String nombre = intent.getStringExtra("string_name");

        /*// Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.txtI);
        TextView textView2 = findViewById(R.id.txtN);
        textView.setText(Integer.toString(intentos));
        textView2.setText(nombre);*/


        // Inicialitzem model
        records = new ArrayList<Record>();
        // Afegim alguns exemples
        records.add( new Record("Jordi",2) );
        records.add( new Record("Manu",3) );
        records.add( new Record("Maria",4) );
        records.add(new Record(nombre, intentos));
        Collections.sort(records);

        adapter = new ArrayAdapter<Record>( this, R.layout.list_item, records ){
            public View getView(int pos, View convertView, ViewGroup container)
            {
                // getView ens construeix el layout i hi "pinta" els valors de l'element en la posició pos
                if( convertView==null ) {
                    // inicialitzem l'element la View amb el seu layout
                    convertView = getLayoutInflater().inflate(R.layout.list_item, container, false);
                }
                // "Pintem" valors (també quan es refresca)
                ((TextView) convertView.findViewById(R.id.nom)).setText(getItem(pos).nombre);
                ((TextView) convertView.findViewById(R.id.intents)).setText(Integer.toString(getItem(pos).intentos));
                return convertView;
            };
        };

        // busquem la ListView i li endollem el ArrayAdapter
        ListView lv = (ListView) findViewById(R.id.recordsView);
        lv.setAdapter(adapter);
    }




}
