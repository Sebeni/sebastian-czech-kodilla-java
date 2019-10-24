package com.kodilla.exception.index;

import java.util.List;

public class IndexExceptionRunner {

    public static void main(String[] args) {
        VideoCollector vc = new VideoCollector();
        List<String> collection = vc.getCollection();

        if(collection.size() > 2) {
            String movie = collection.get(0);
            System.out.println(movie);

            String anotherMovie = collection.get(2);
            System.out.println(anotherMovie);
        }
    }
}
