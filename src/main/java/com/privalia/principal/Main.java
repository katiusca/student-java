package com.privalia.principal;

import com.privalia.dao.StudentDao;
import com.privalia.model.StudentWithLombok;

import java.io.IOException;

import static com.privalia.model.StudentWithLombok.getStudent;

public class Main {
    public static void main(String[] args) {
        System.out.println("******Init*******");
        try {
            StudentWithLombok kati = getStudent();
            kati.setIdStudent(1);
            kati.setName("cat");
            kati.setSurname("dog");
            kati.setAge(20);
            StudentDao dao = new StudentDao();
            dao.add(kati);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("******Finished*******");
    }
}
