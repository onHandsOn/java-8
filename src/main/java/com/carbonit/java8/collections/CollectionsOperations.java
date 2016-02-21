package com.carbonit.java8.collections;

import com.carbonit.java8.model.Person;

import java.util.*;

public class CollectionsOperations {

    private CollectionsOperations() {
    }

    public static void doubleSalary(Map<Person, Integer> salaryByPerson){
        //TODO: replace with forEach method
        for (Map.Entry<Person, Integer> entrySet : salaryByPerson.entrySet()){
                entrySet.setValue(entrySet.getValue() * 2);
        }
    }

    public static void incrementAge(List<Person> people){
        //TODO: replace with forEach method
        for (Person person : people) {
            person.age ++;
        }
    }

    public static void sortByAge(List<Person> people){
        //TODO: replace with sort method directly from the input list
        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.age - p2.age;
            }
        };
        Collections.sort(people, comparator);
    }
}
