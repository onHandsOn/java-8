package com.carbonit.java8.collections;

import com.carbonit.java8.exception.NoStudentFoundException;
import com.carbonit.java8.model.Person;
import com.carbonit.java8.model.Student;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;

public class StreamOperations {

    private StreamOperations() {
    }

    public static List<Integer> buildNumberList(int listSize){
        // TODO use IntStream
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= listSize; i ++) {
            result.add(i);
        }

        return  result;
    }

    public static List<Integer> filterOnEvenNumber(List<Integer> myList) {
        // TODO use filter
        List<Integer> result = new ArrayList<>();
        for (Integer number : myList) {
            if (number % 2 == 0) {
                result.add(number);
            }
        }
        return result;
    }

    public static Map<Integer, List<Person>> groupingByAge(List<Person> people){
        // TODO use method groupingBy
        Map<Integer, List<Person>> personByAge = new HashMap<>();
        for (Person person : people){
            List<Person> groupedPeople = personByAge.get(person.age);
            if (groupedPeople == null){
                personByAge.put(person.age, asList(person));
            }
            else {
                List<Person> list = new ArrayList<>(groupedPeople);
                list.add(person);
                personByAge.put(person.age, list);
            }
        }
        return personByAge;
    }

    public static Person findOlderPerson(List<Person> people){
        //TODO use find first
        Person olderPerson = people.get(0);
        for (Person person : people){
            if (person.age > olderPerson.age) {
                olderPerson = person;
            }
        }
        return olderPerson;
    }

    public static List<Student> findStudents(List<Person> people) {
        //TODO use map
        List<Student> students = new ArrayList<>();

        for(Person person : people){
            if (person.age > 18){
                students.add(new Student());
            }
        }
        return students;
    }

    public static int countNbStudents(List<Person> people){
        // TODO use count
        int compteur = 0;
        for(Person person : people){
            if (person.age > 18){
                compteur ++;
            }
        }
        return compteur;
    }

    public static Student addAYearAndGetFirstStudent(List<Person> people) throws Exception {
        // TODO use peek to add a year
        for (Person person : people){
            person.age ++;
            if (person.age > 18){
                return new Student(person);
            }
        }
        throw new NoStudentFoundException();
    }

    public static Double getAverageAge(List<Person> people){
        // TODO use average method
        Double sumAge = 0d;
        for (Person person : people) {
            sumAge = sumAge + person.age;
        }
        return sumAge/people.size();
    }

    public static List<String> getDistinctDevelopmentLangages(List<Student> students){
        //TODO use flatMap
        List<String> result = new ArrayList<>();
        Set<String> geekDevelopmentLangages = new HashSet<>();
        for (Student student : students) {
            for (String geekLangage : student.langages){
                geekDevelopmentLangages.add(geekLangage);
            }
        }
        result.addAll(geekDevelopmentLangages);
        return result;

    }

}
