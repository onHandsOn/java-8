package com.carbonit.java8.model;

public class PersonBuilder {

    public String lastName;
    public String firstName;
    public int age;

    private PersonBuilder() {
    }

    public static PersonBuilder aPersonBuilder(){
        return new PersonBuilder();
    }

    public PersonBuilder withLastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public PersonBuilder withFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public PersonBuilder withAge(int age){
        this.age = age;
        return this;
    }

    public Person build(){
        return new Person(this.lastName, this.firstName, this.age);
    }
}
