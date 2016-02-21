package com.carbonit.java8.model;

public class Person {

    public String lastName;
    public String firstName;
    public int age;

    public Person(String line) {
        this.firstName = line.split(";")[0];
        this.lastName = line.split(";")[1];
        this.age = Integer.valueOf(line.split(";")[2]);
    }

    public Person(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) return false;
        return !(firstName != null ? !firstName.equals(person.firstName) : person.firstName != null);

    }

    @Override
    public int hashCode() {
        int result = lastName != null ? lastName.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }
}
