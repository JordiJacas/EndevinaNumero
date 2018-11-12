package com.example.tnb_20.endevinanumero;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlSerializer;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Main2Activity extends AppCompatActivity {

    ArrayList<Record> records;
    ArrayAdapter<Record> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);


        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        int intentos = intent.getIntExtra("int_value",0);
        String nombre = intent.getStringExtra("string_name");
        Record r = new Record(nombre, intentos);


        // Inicialitzem model
        records = new ArrayList<Record>();
        records = r.getRecords();
        String FILENAME = "file.xml";

        //Insertamos los records dentro del xml
        try {
            FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            XmlSerializer serializer = Xml.newSerializer();
            serializer.setOutput(fos, "UTF-8");
            serializer.startDocument(null, Boolean.valueOf((true)));
            serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
            serializer.startTag(null, "root");

            for (Record record:records){
                serializer.startTag(null, "name");
                serializer.text(record.getNombre());
                serializer.endTag(null, "name");

                serializer.startTag(null, "record");
                serializer.text(Integer.toString(record.getIntentos()));
                serializer.endTag(null, "record");
            }

            serializer.endDocument();
            serializer.flush();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*Leemos todos los records del
        FileInputStream fis = null;
        InputStreamReader isr = null;
        InputStream is = null;

        try {
            fis = getApplicationContext().openFileInput(FILENAME);
            isr = new InputStreamReader(fis);
            char[] inputBuffer = new char[fis.available()];
            isr.read(inputBuffer);
            String data = new String(inputBuffer);
            isr.close();
            fis.close();
            is = new ByteArrayInputStream(data.getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        NodeList itemsRecord = null;
        NodeList itemsName = null;
        Document dom = null;

        try {
            Record xmlDataObj;
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse(is);
            dom.getDocumentElement().normalize();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        itemsRecord = dom.getElementsByTagName("record");
        itemsName = dom.getElementsByTagName("name");
        records = null;

        for (int i=0; i<itemsRecord.getLength();i++){
            Node itemRecord = itemsRecord.item(i);
            Node itemName = itemsName.item(i);
            records.add(new Record(itemName.getNodeValue(), Integer.parseInt(itemRecord.getNodeValue())));
        }*/


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
