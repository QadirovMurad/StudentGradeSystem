package com.murad.members;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com .murad.main.FileUtility;
public class Dechan  {


    public static void seeSchedule() throws IOException {
        List<Student> arr = FileUtility.read();
        System.out.println("Schedule\n-----------------\nStudents Who got Grade 'A'");
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getGrade() >= 91) {
                seeStudent(arr.get(i));

            }

        }
        System.out.println("------------------");
        System.out.println("Students Who got Grade 'B'");
        for (int i = 0; i < arr.size(); i++) {

            if (arr.get(i).getGrade() < 91 && arr.get(i).getGrade() >= 81) {
                seeStudent(arr.get(i));

            }

        }
        System.out.println("------------------");
        System.out.println("Students Who got Grade 'C'");
        for (int i = 0; i < arr.size(); i++) {

            if (arr.get(i).getGrade() < 81 && arr.get(i).getGrade() >= 71) {
                seeStudent(arr.get(i));
            }


        }
        System.out.println("------------------");
        System.out.println("Students Who got Grade 'D'");
        for (int i = 0; i < arr.size(); i++) {


            if (arr.get(i).getGrade() < 71 && arr.get(i).getGrade() >= 61) {
                seeStudent(arr.get(i));
            }
        }
        System.out.println("------------------");
        System.out.println("Students Who got Grade 'E'");
        for (int i = 0; i < arr.size(); i++) {


            if (arr.get(i).getGrade() < 61 && arr.get(i).getGrade() >= 51) {
                seeStudent(arr.get(i));
            }
        }
        System.out.println("------------------");
        System.out.println("Students Who Failed ");
        for (int i = 0; i < arr.size(); i++) {


            if (arr.get(i).getGrade() < 51) {
                seeStudent(arr.get(i));
            }
        }

    }

    public static void seeStudent(Student st){
        System.out.println("ID : "+st.getId());
        System.out.println("Name : " + st.getName());
        System.out.println("Surname : " + st.getSurName());
        System.out.println("Lesson name : " + st.subjectName);
        System.out.println("Grade : " + st.getGrade());

    }
}
