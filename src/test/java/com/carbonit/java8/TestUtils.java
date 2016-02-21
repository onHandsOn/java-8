package com.carbonit.java8;

import com.carbonit.java8.model.Person;
import com.carbonit.java8.model.Student;
import com.carbonit.java8.model.StudentBuilder;

import java.util.List;

import static com.carbonit.java8.model.PersonBuilder.aPersonBuilder;
import static com.carbonit.java8.model.StudentBuilder.*;

public class TestUtils {

    private TestUtils() {
    }

    public static Person generateAPerson(String lastName, String firstName, int age) {
        return aPersonBuilder()
                .withLastName(lastName)
                .withFirstName(firstName)
                .withAge(age)
                .build();
    }

    public static Student generateStudent(String lastName, String firstName, int age, List<String> langages) {
        return aStudentBuilder()
                .withLastName(lastName)
                .withFirstName(firstName)
                .withAge(age)
                .withLangages(langages)
                .build();
    }
}
