package com.carbonit.java8.files;

import com.carbonit.java8.model.Person;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesOperations {

    private FilesOperations() {
    }

    public static List<Person> readLinesFromAFile(URI uri) throws Exception {
        try (Stream<String> stream = Files.lines(Paths.get(uri))) {
            return stream.map(Person::new).collect(Collectors.toList());
        } catch (IOException e) {
            throw new Exception(e);
        }
    }
}
