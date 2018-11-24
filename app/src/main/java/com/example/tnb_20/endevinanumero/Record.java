package com.example.tnb_20.endevinanumero;

import java.util.ArrayList;

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

    public int getIntentos(){
        return intentos;
    }

    public String getNombre(){
        return nombre;
    }

}
