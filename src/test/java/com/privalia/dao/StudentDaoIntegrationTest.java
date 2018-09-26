package com.privalia.dao;

import com.privalia.model.StudentWithLombok;
import com.privalia.util.Util;
import lombok.extern.log4j.Log4j;
import org.junit.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import static org.junit.Assert.assertEquals;

@Log4j
public class StudentDaoIntegrationTest {

    static Properties properties = null;
    static FileInputStream inputStream = null;

    @BeforeClass
    public static void setUp() throws IOException{
        log.info("Student integration test started");
        properties = new Properties();
        try {
            inputStream = new FileInputStream("src/test/resources/config-test.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }

    @AfterClass
    public static void tearDown() throws IOException{
        File file = Util.getFile();
        if (file.exists()) {
            file.delete();
        }
        log.info("AfterClass");
    }

    @Test
    public void shouldAddStudent() throws IOException {
        StudentWithLombok student = new StudentWithLombok(1, "kati", "Leal", 29);
        log.info(student.toString());
        StudentDao studentDao = new StudentDao();
        StudentWithLombok studentFound = studentDao.add(student);
        log.info(studentFound);
        assertEquals(student,studentFound);
    }
}
