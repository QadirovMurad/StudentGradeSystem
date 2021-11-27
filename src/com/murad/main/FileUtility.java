package com.murad.main;

import com.murad.members.Registration;
import com.murad.members.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtility {
    private static final String FILE_PATH = "C:\\Users\\hp\\Desktop/Student_Grades";
    private static File f = new File(FILE_PATH);

    private static final String PATH_TO_GRADE = FILE_PATH + File.separator + "grades.txt";
    private static final String PATH_TO_LOGINS = FILE_PATH + File.separator + "logins.txt";
    private static final String PATH_TO_ID = FILE_PATH + File.separator + "id.txt";

    public static void writeStudentintoFile(Student st, boolean a) throws IOException {
        if (!f.exists()) {
            f.mkdir();
        }
        FileWriter fw = new FileWriter(PATH_TO_GRADE, a);
        try (BufferedWriter bw = new BufferedWriter(fw);) {
            bw.write(st.getId()+"--"+st.getName() + "--" + st.getSurName() + "--" + st.subjectName + "--" + st.getGrade());
            bw.newLine();
        }
        System.out.println("Successfully Done !");

    }

    public static void writeLoginsintoFile(Registration p, boolean a) throws IOException {
        if (!f.exists()) {
            f.delete();
            f.mkdir();
        }
        FileWriter fw = new FileWriter(PATH_TO_LOGINS, a);
        try (BufferedWriter bw = new BufferedWriter(fw);) {
            bw.write(p.getUserName() + "&&" + p.getPassword() + "&&" + p.getIdentity());
            bw.newLine();
        }
        System.out.println("Successfully Done !");

    }

    public static List<Student> read() throws IOException {
        try (FileReader fr = new FileReader(PATH_TO_GRADE);
             BufferedReader reader = new BufferedReader(fr);) {
            List<Student> listOfStudents = new ArrayList<>();

            while (reader.ready()) {

                Student st = new Student();
                String[] arr = reader.readLine().split("--");
                st.setId(Integer.parseInt(arr[0]));
                st.setName(arr[1]);
                st.setSurName(arr[2]);
                st.setGrade(Byte.parseByte(arr[4]));
                listOfStudents.add(st);


            }
            return listOfStudents;

        }


    }

    public static List<Registration> readLogins() throws IOException {
        try (FileReader fr = new FileReader(PATH_TO_LOGINS);
             BufferedReader reader = new BufferedReader(fr);) {
            List<Registration> listOfLogins = new ArrayList<>();

            while (reader.ready()) {

                Registration p = new Registration();
                String[] arr = reader.readLine().split("&&");
                p.setUserName(arr[0]);
                p.setPassword(arr[1]);
                p.setIdentity(Integer.parseInt(arr[2]));
                listOfLogins.add(p);


            }
            return listOfLogins;

        }
    }

    public static void writeIdIntoFile(String x) throws IOException {
        if (!f.exists()) {
            f.mkdir();
        }
        FileWriter fw = new FileWriter(PATH_TO_ID);
        try (BufferedWriter bw = new BufferedWriter(fw);) {
            bw.write(x);

        }
        System.out.println("Successfully Done !");
    }

    public static int readId() throws IOException {
        try (FileReader fr = new FileReader(PATH_TO_ID);
             BufferedReader reader = new BufferedReader(fr);) {
            Integer a = Integer.parseInt(reader.readLine());
            return a;
        }
    }
}
