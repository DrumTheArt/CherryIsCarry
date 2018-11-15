package com.wachs.testing.unitTests;

import com.wachs.main.dataBaseLayer.Util.ConverterStringForDataBase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class UtilClassTests {

    private ConverterStringForDataBase convertString;

    @Before
    public void setUp() {

        convertString = new ConverterStringForDataBase();
    }

    @Test
    public void testConvertFirstCharFromLowerToUpper() {

        String inputName = "roberT";
        //Set firstLetter to upperCase and set last to lowerLetters
        String expectedName = "Robert";
        String convertedName = convertString.convertString(inputName);
        assertEquals(expectedName, convertedName);

    }

    @Test
    public void testDoNotConvertIfStringIsAllright() {

        String inputName = "Robert";
        //Set firstLetter to upperCase and set last to lowerLetters
        String expectedName = "Robert";
        String convertedName = convertString.convertString(inputName);
        assertEquals(expectedName, convertedName);

    }

    @Test
    public void testDoNothingIfFirstCharisANumberButSecondIsUpperCaseLetter() {

        String inputName = "1Robert";
        //Set firstLetter to upperCase and set last to lowerLetters
        String expectedName = "1robert";
        String convertedName = convertString.convertString(inputName);
        assertEquals(expectedName, convertedName);

    }

    @Test
    public void testDropTrimAtBeginningOrEnd() {

        String inputName = " robert ";
        //Set firstLetter to upperCase and set last to lowerLetters
        String expectedName = "Robert";
        String convertedName = convertString.convertString(inputName);
        System.out.println(inputName);
        System.out.println(expectedName);
        System.out.println(convertedName);
        assertEquals(expectedName, convertedName);

    }
}