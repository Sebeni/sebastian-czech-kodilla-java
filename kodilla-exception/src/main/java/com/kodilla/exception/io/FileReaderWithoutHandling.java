package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReaderWithoutHandling {
   
    public void readFile() throws IOException {

        File file = new File(getClass().getClassLoader().getResource("file/names.txt").getFile());
        System.out.println(file.getPath());


        Stream<String> fileLines = Files.lines(Paths.get(file.getPath()));
        fileLines.forEach(System.out::println);
        
    }
    
}
