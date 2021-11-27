package com.murad.main;

import com.murad.members.Dechan;
import com.murad.members.Registration;
import com.murad.members.Student;
import com.murad.members.Laborant;

import java.util.List;
import java.util.Scanner;

public class Method {
    private static Scanner sc = new Scanner(System.in);

    public static void startProgram() throws Exception {

        System.out.println("Welcome to Our Console App !");
        System.out.println("Enter as a ...\n1.Dechan\n2.Laborant\n3.Student\n4.Registration");
        Integer choice;

        System.out.print("Choice : ");
        choice = sc.nextInt();
        String arr[] = null;
        if (FileUtility.read().isEmpty() && choice == 1) {
            System.out.println("First add students then see schedule ");
            startProgram();
        }
        if (FileUtility.readLogins().isEmpty() && choice == 4) {
            System.out.println("First login ! ");
            startProgram();
        }
        switch (choice) {
            case 1:
                arr = enterUserNameAndPassword();

                if (checkDechanUserNameAndPassword(arr[0], arr[1]))
                    Dechan.seeSchedule();
                else
                    System.err.println("Wrong User Name or Password !");

                break;
            case 2:
                arr = enterUserNameAndPassword();
                if (checkLaborantUserNameAndPassword(arr[0], arr[1])) {
                   Laborant.performeOneOfTheTask();
                } else
                    System.err.println("Wrong User Name or Password !");
                break;

            case 3:

                Student.seeMyResult(enterStudentNameAndSurname());
                break;
            case 4:
                Registration.register();

                break;
            default:
                System.err.println("Invalid Input");
                return;
        }
        System.out.println("1.Exit Program\n2.Switch to another account\nChoice : ");
        choice = sc.nextInt();
        if (choice == 1)
            System.out.println("Successfully Exited !");
        else if (choice == 2) {
            startProgram();
        } else
            System.err.println("Invalid input !");
    }

    public static String[] enterUserNameAndPassword() {
        Scanner sc = new Scanner(System.in);
        String[] nameAndPassword = new String[2];
        System.out.println("Enter user name :");
        String userName = sc.next();
        sc.nextLine();
        System.out.println("Enter password :");
        String password = sc.next();
        nameAndPassword[0] = userName;
        nameAndPassword[1] = password;
        return nameAndPassword;
    }

    public static boolean checkDechanUserNameAndPassword(String userName, String password) throws Exception {
        List<Registration> p = FileUtility.readLogins();
        boolean a = false;
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i).getUserName().equalsIgnoreCase(userName) && p.get(i).getPassword().equals(password) && p.get(i).getIdentity() == 1)
                a = true;

        }

        return a;

    }

    public static boolean checkLaborantUserNameAndPassword(String userName, String password) throws Exception {
        List<Registration> p = FileUtility.readLogins();
        boolean a = false;
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i).getUserName().equalsIgnoreCase(userName) && p.get(i).getPassword().equals(password) && p.get(i).getIdentity() == 2)
                a = true;

        }
        return a;
    }


    public static String enterStudentNameAndSurname() {
        System.out.println("Enter Your Name And Surname : ");
        sc.nextLine();
        String studentNameAndSurname = sc.nextLine();
        return studentNameAndSurname;
    }
}
