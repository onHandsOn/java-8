package com.carbonit.java8.model;

import java.util.List;

public class StudentBuilder {

    public String lastName;
    public String firstName;
    public int age;
    public List<String> langages;

    private StudentBuilder() {
    }

    public static StudentBuilder aStudentBuilder(){
        return new StudentBuilder();
    }

    public StudentBuilder withLastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public StudentBuilder withFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public StudentBuilder withAge(int age){
        this.age = age;
        return this;
    }

    public StudentBuilder withLangages(List<String> langages){
        this.langages = langages;
        return this;
    }

    public Student build(){
        return new Student(this.lastName, this.firstName, this.age, langages);
    }
}
