package com.carbonit.java8;

import com.carbonit.java8.model.Person;

import static com.carbonit.java8.model.PersonBuilder.aPersonBuilder;

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
}
