package com.kodilla.exception.io;

import java.io.File;
import java.net.URL;

public class FileReader {
    
    public void readFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource("file/names.txt");
        System.out.println(url);
        
        URL url1 = getClass().getResource("file/names.txt");
        System.out.println(url1);
        
        File file = new File(url.getFile());
        
    }
    
}
