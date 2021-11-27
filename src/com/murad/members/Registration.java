package com.murad.members;

import com.murad.main.FileUtility;

import java.io.IOException;
import java.util.Scanner;

public class Registration {
    private static Scanner sc = new Scanner(System.in);

    private String UserName;
    private String Password;
    private int identity;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    public static void register () throws IOException {
        Registration p = new Registration();
        System.out.println("Enter new UserName");
        String newUserName=sc.next();
        sc.nextLine();
        System.out.println("Enter new Password");
        String newPassword=sc.next();
        System.out.println("Enter identity (1.Dechan 2.Laborant");
        int newIdentity=sc.nextInt();
        p.setUserName(newUserName);
        p.setPassword(newPassword);
        p.setIdentity(newIdentity);
        FileUtility.writeLoginsintoFile(p,true);
    }
}
