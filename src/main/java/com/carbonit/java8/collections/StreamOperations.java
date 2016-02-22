package com.carbonit.java8.collections;

import com.carbonit.java8.exception.NoStudentFoundException;
import com.carbonit.java8.model.Person;
import com.carbonit.java8.model.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class StreamOperations {

    private StreamOperations() {
    }

    public static List<Integer> buildNumberList(int listSize){
        return IntStream.rangeClosed(1, listSize).boxed().collect(toList());
    }

    public static List<Integer> filterOnEvenNumber(List<Integer> myList) {
        return myList.stream().filter(number -> number % 2 == 0 ).collect(toList());
    }

    public static Map<Integer, List<Person>> groupingByAge(List<Person> people){
        return people.stream().collect(groupingBy(person -> person.age));
    }

    public static Person findOlderPerson(List<Person> people){
        return people.stream().sorted((p1, p2) -> p2.age - p1.age).findFirst().get();
    }

    public static List<Student> findStudents(List<Person> people) {
        return people.stream().filter(p -> p.age > 18).map(Student::new).collect(toList());
    }

    public static int countNbStudents(List<Person> people){
        return (int) people.stream().filter(p -> p.age > 18).count();
    }

    public static Student addAYearAndGetFirstStudent(List<Person> people) throws Exception {
        return people.stream()
                .peek(person -> person.age ++)
                .filter(p -> p.age > 18)
                .map(Student::new)
                .findFirst()
                .orElseThrow(NoStudentFoundException::new);
    }

    public static Double getAverageAge(List<Person> people){
        return people.stream().map(p -> p.age).mapToDouble(Integer::doubleValue).average().getAsDouble();
    }

    public static List<String> getDistinctDevelopmentLangages(List<Student> students){
        return students.stream().flatMap(student -> student.langages.stream()).distinct().collect(toList());
    }

}
