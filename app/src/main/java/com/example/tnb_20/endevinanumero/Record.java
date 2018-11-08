package com.example.tnb_20.endevinanumero;

import java.util.ArrayList;

public class Record implements Comparable<Record>{
    public int intentos;
    public String nombre;
    public static ArrayList<Record> records = new ArrayList<Record>();

    public Record(){};
    public Record(String nombre, int intentos){
        this.nombre = nombre;
        this.intentos = intentos;
        addRecord();

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

    public void addRecord(){
        records.add(this);
    }

    public ArrayList<Record> getRecords(){
        return records;
    }
}
