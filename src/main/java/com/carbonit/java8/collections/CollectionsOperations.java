package com.carbonit.java8.collections;

import com.carbonit.java8.model.Person;

import java.util.*;

public class CollectionsOperations {

    private CollectionsOperations() {
    }

    public static void doubleSalary(Map<Person, Integer> salaryByPerson){
        salaryByPerson.forEach((person, integer) -> salaryByPerson.put(person, integer * 2));
    }

    public static void incrementAge(List<Person> people){
        people.forEach(person -> person.age ++);
    }

    public static void sortByAge(List<Person> people){
        people.sort((p1, p2) -> p1.age - p2.age);
    }
}
