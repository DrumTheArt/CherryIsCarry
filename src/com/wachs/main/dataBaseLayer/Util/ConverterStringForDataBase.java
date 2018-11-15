package com.wachs.main.dataBaseLayer.Util;

public class ConverterStringForDataBase {


    public String convertString(String name){

    //Because every string should start with a Capital, Rest lowerCases and not should not include spaces
    int countLettersName = name.length();
    String firstLetter = name.substring(0,1).toUpperCase();
    String lastLetters = name.substring(1,countLettersName).toLowerCase();

    name = firstLetter + lastLetters;
    name = name.trim();

    return name;

    }

}
