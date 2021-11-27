package com.murad.otherTasks;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfNumbers;
        System.out.println("How many number would you like to enter ? :  ");
        numOfNumbers=sc.nextInt();
        double[] arr = new double[numOfNumbers];
        for (int i = 0; i < numOfNumbers; i++) {
            arr[i]=sc.nextDouble();

        }

    }

    public static double foo(double[] a) {
        double min = 2;
        for (int i = 1; i < a.length; i++) {
            if (a[i] / 2 == 0 && a[i] < min)
                min = a[i];
        }
        return min;

    }

    public static double[] foo2(double[] a) {
        double tekEdediOrta = 0;
        double cutEdediOrta = 0;
        int tekEdedlerSayi = 0, cutEdedlerSayi = 0;
        double[] edediOrtalar=new double[2];
        for (int i = 1; i < a.length; i++) {
            if (a[i] / 2 == 0) {
                cutEdediOrta += a[i];
                cutEdedlerSayi++;
            } else {
                tekEdediOrta += a[i];
                tekEdedlerSayi++;
            }

            edediOrtalar[0]=tekEdediOrta / tekEdedlerSayi;
            edediOrtalar[1]=cutEdediOrta / cutEdedlerSayi;
        }
        return edediOrtalar;

    }
}
