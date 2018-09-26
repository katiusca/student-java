package com.privalia.dao;

import com.privalia.model.StudentWithLombok;
import java.io.*;
import java.util.Properties;
import org.apache.log4j.Logger;
import static com.privalia.util.Util.createFile;

public class StudentDao implements IDao<StudentWithLombok> {

    static final Logger logger = Logger.getLogger(StudentDao.class);
    static Properties properties = null;
    static FileInputStream inputStream = null;
    static {
        properties = new Properties();
        try {
            inputStream = new FileInputStream("src/main/resources/config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }

    public StudentWithLombok add(StudentWithLombok model) throws IOException {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        String filename = properties.getProperty("filename");
        createFile(filename);
        try {
            fileWriter = new FileWriter(filename, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(model.toString());
            bufferedWriter.write(System.lineSeparator());
        } catch (IOException e){
            logger.error(e.getMessage());
        } finally {
            if (bufferedWriter != null)
                bufferedWriter.close();

            if (fileWriter != null)
                fileWriter.close();
        }
        return getLastStudentById(model.getIdStudent());

    }

    private StudentWithLombok getLastStudentById(Integer id) throws IOException {
        BufferedReader bufferedReader = null;
        StudentWithLombok student = new StudentWithLombok();
        String filename = properties.getProperty("filename");
        try {
            bufferedReader = new BufferedReader(new FileReader(filename));
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {

                String [] datos = linea.split("," , 4);
                if(datos[0].equals(String.valueOf(id))) {
                    student.setIdStudent(id);
                    student.setName(datos[1]);
                    student.setSurname(datos[2]);
                    student.setAge(Integer.valueOf(datos[3]));
                    break;
                }
            }
        } catch(IOException e) {
            logger.error(e.getMessage());
            throw e;
        }finally {
            if (bufferedReader != null){
                bufferedReader.close();
            }
        }
        return student;
    }
}
