package com.wachs.main.DatumBeispiel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BeispielDate {

    public static void main(String[] args){

    SimpleDateFormat dateformat2 = new SimpleDateFormat("dd/MM/yyyy");

    String strdate2 = "28/04/2013";

        Date date = null;
        try {
            date = dateformat2.parse(strdate2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(dateformat2.format(date));


    }
}
