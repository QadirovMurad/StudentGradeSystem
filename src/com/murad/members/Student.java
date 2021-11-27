package com.murad.members;

import com.murad.main.FileUtility;

import java.util.List;

public class Student {
    private Integer id;
    private String name;
    private String surName;
    private byte grade;
    public final String subjectName = "Java";

    public static void seeMyResult(String nameAndSurname) throws Exception {
        List<Student> st = FileUtility.read();
        boolean a = false;
        for (int i = 0; i < st.size(); i++) {

            if ((st.get(i).getName() + " " + st.get(i).getSurName()).equalsIgnoreCase(nameAndSurname)) {
                System.out.println("Name : " + st.get(i).getName());
                System.out.println("Surname : " + st.get(i).getSurName());
                System.out.println("Lesson name : " + st.get(i).subjectName);
                System.out.println("Grade : " + st.get(i).getGrade());
                if (st.get(i).getGrade() < 51)
                    System.out.println("You Failed !");
                ;
                a = true;
            }

        }
        if (!a)
            System.out.println("No information !");
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public byte getGrade() {
        return grade;
    }

    public void setGrade(byte grade) {
        this.grade = grade;
    }

}
