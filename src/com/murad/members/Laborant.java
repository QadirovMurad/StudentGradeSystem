package com.murad.members;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.murad.main.FileUtility;

public class Laborant {
    public static Scanner sc = new Scanner(System.in);

    public static void addStudentInformation() throws IOException {

        Student st = new Student();
        System.out.println("How many student will yo enter ? ");
        System.out.print("Number : ");
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            sc.nextLine();
            Integer id = FileUtility.readId();
            System.out.println("Enter Student name : ");
            String name = sc.next();
            System.out.println("Enter Student surname : ");
            String surName = sc.next();
            System.out.println("Enter Student grade : ");
            byte grade = sc.nextByte();
            st.setId(id);
            st.setName(name);
            st.setSurName(surName);
            st.setGrade(grade);
            id++;
            FileUtility.writeIdIntoFile(id.toString());
            FileUtility.writeStudentintoFile(st, true);


        }

    }

    public static void updateStudentInformation() throws IOException {
        List<Student> students = FileUtility.read();
        List<Student> updatedStudents = new ArrayList<>();
        int ch;
        System.out.print("Enter the ID of the student to update : ");
        ch = sc.nextInt();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == ch) {
                Dechan.seeStudent(students.get(i));
                Student st = new Student();
                System.out.println("Enter Student name : ");
                String name = sc.next();
                System.out.println("Enter Student surname : ");
                String surName = sc.next();
                System.out.println("Enter Student grade : ");
                byte grade = sc.nextByte();
                st.setId(students.get(i).getId());
                st.setName(name);
                st.setSurName(surName);
                st.setGrade(grade);
                updatedStudents.add(st);
            } else
                updatedStudents.add(students.get(i));

        }
        for (int j = 0; j < updatedStudents.size(); j++) {
            if (j == 0)
                FileUtility.writeStudentintoFile(updatedStudents.get(j), false);
            else
                FileUtility.writeStudentintoFile(updatedStudents.get(j), true);
        }


    }

    public static void deleteStudentInformation() throws IOException {
        List<Student> students = FileUtility.read();
        List<Student> updatedStudents = new ArrayList<>();
        int ch;
        System.out.print("Enter the ID of the student to update : ");
        ch = sc.nextInt();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == ch) {
                students.remove(i);
            }

        }
        updatedStudents = students;
        for (int j = 0; j < updatedStudents.size(); j++) {
            if (j == 0)
                FileUtility.writeStudentintoFile(updatedStudents.get(j), false);
            else
                FileUtility.writeStudentintoFile(updatedStudents.get(j), true);
        }

    }

    public static void searchStudentInformation() throws Exception {
        String nameAndSurname;
        System.out.println("Enter Student name and surname : ");
        nameAndSurname = sc.nextLine();
        List<Student> st = FileUtility.read();
        boolean a = false;
        for (int i = 0; i < st.size(); i++) {

            if ((st.get(i).getName() + " " + st.get(i).getSurName()).equalsIgnoreCase(nameAndSurname)) {
                System.out.println("ID : " + st.get(i).getId());
                System.out.println("Name : " + st.get(i).getName());
                System.out.println("Surname : " + st.get(i).getSurName());
                System.out.println("Lesson name : " + st.get(i).subjectName);
                System.out.println("Grade : " + st.get(i).getGrade());

                a = true;
            }

        }
        if (!a)
            System.out.println("No information !");
    }

    public static void searchStudentInformationID() throws Exception {
        List<Student> students = FileUtility.read();
        boolean a = false;
        System.out.print("Enter the ID of the student : ");
        int ch = sc.nextInt();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == ch) {
                System.out.println("ID : " + students.get(i).getId());
                System.out.println("Name : " + students.get(i).getName());
                System.out.println("Surname : " + students.get(i).getSurName());
                System.out.println("Lesson name : " + students.get(i).subjectName);
                System.out.println("Grade : " + students.get(i).getGrade());
                a = true;
            }

        }
        if (!a)
            System.out.println("No information !");
    }

    public static void performeOneOfTheTask() throws Exception {
        System.out.println("1.Add Student\n2.Update Student\n3.Delete Student\n4.Search Student");
        System.out.print("Choice : ");
        int ch = sc.nextInt();
        if (ch == 1)
            addStudentInformation();
        else if (ch == 2)
            updateStudentInformation();
        else if (ch == 3)
            deleteStudentInformation();
        else if (ch == 4) {
            int choice;
            System.out.println("Search according to 1.ID or 2.Name and Surname");
            choice = sc.nextInt();
            if (choice == 1)
                searchStudentInformationID();
            else if (choice == 2)
                searchStudentInformation();
            else
                System.out.println("Wrong Input !!!");
        } else
            System.out.println("Wrong Input !!!");

    }
}
