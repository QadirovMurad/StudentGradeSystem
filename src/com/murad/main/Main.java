package com.murad.main;

import java.io.File;
import java.io.FileWriter;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args)  {

        try {
            Method.startProgram();
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }
}
