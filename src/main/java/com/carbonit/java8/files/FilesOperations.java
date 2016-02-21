package com.carbonit.java8.files;

import com.carbonit.java8.model.Person;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilesOperations {

    private FilesOperations() {
    }

    public static List<Person> readLinesFromAFile(URI uri) throws Exception {
        // TODO use lines method
        List<Person> people = new ArrayList<>();
        try {
            List<String> peopleAsString = Files.readAllLines(Paths.get(uri));
            for (String personAsString : peopleAsString){
                people.add(new Person(personAsString));
            }
        } catch (IOException e) {
            throw new Exception(e);
        }
        return people;
    }
}
