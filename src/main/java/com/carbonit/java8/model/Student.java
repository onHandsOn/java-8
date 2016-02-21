package com.carbonit.java8.model;

import java.util.ArrayList;
import java.util.List;

public class Student {

    public String firstName;

    public String lastName;

    public int age;

    public List<String> langages;

    public Student() {
    }

    public Student(Person person) {
        this.firstName = person.firstName;
        this.lastName = person.lastName;
        this.age = person.age;
        this.langages = new ArrayList<>();
    }


    public Student(String firstName, String lastName, int age, List<String> langages) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.langages = langages;
    }
}
