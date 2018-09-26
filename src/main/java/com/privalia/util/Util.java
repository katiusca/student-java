package com.privalia.util;

import lombok.extern.log4j.Log4j;
import java.io.File;
import java.io.IOException;

@Log4j
public class Util {

    private static File file = null;

    public static synchronized boolean createFile(String name) throws IOException{
        boolean isFileCreated = false;
        file = new File(name);

        if(file.exists()) {
            log.warn("El fichero existe");
        } else {
            try {
                isFileCreated = file.createNewFile();
            } catch (IOException e) {
                log.error(e.getMessage());
                throw e;
            }
        }
        return isFileCreated;
    }

    public static File getFile() {
        return file;
    }
}