package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {

    public void readFile() throws FileReaderException{

        File file = new File(getClass().getClassLoader().getResource("file/names.txt").getFile());
        System.out.println(file.getPath());


        try (Stream<String> fileLines = Files.lines(Paths.get("file.getPath()"))) {

            fileLines.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Something wrong :(" + e);
            throw new FileReaderException();
        } finally {
            System.out.println("Finally");
        }


    }

}
