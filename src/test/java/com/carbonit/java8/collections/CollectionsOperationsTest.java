package com.carbonit.java8.collections;

import com.carbonit.java8.model.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.carbonit.java8.TestUtils.generateAPerson;
import static com.carbonit.java8.collections.CollectionsOperations.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CollectionsOperationsTest {

    @Test
    public void should_increment_salary() {
        // Given
        Map<Person, Integer> salaryByPerson = new HashMap<>();
        Person firstPerson = generateAPerson("Dupont", "John", 35);
        salaryByPerson.put(firstPerson, 2500);
        Person secondPerson = generateAPerson("Bond", "James", 30);
        salaryByPerson.put(secondPerson, 7500);

        // When
        doubleSalary(salaryByPerson);

        // Then
        assertThat(salaryByPerson.get(firstPerson)).isEqualTo(5000);
        assertThat(salaryByPerson.get(secondPerson)).isEqualTo(15000);
    }

    @Test
    public void should_increment_age() throws Exception {
        // Given
        Person firstPerson = generateAPerson("Frank", "Julie", 65);
        Person secondPerson = generateAPerson("Bernard", "Louise", 15);

        List<Person> people = Arrays.asList(firstPerson, secondPerson);

        // When
        incrementAge(people);

        // Then
        assertThat(people.size()).isEqualTo(2);
        assertThat(people.get(0).age).isEqualTo(66);
        assertThat(people.get(1).age).isEqualTo(16);
    }

    @Test
    public void sould_sort_people_by_age() {

        // Given
        Person person1 = generateAPerson("Frank", "Julie", 65);
        Person person2 = generateAPerson("Bernard", "Louise", 15);
        Person person3 = generateAPerson("Pierre", "Richard", 6);
        Person person4 = generateAPerson("Reno", "Jean", 23);

        List<Person> people = Arrays.asList(person1, person2, person3, person4);

        // When
        sortByAge(people);

        // Then
        assertThat(people.size()).isEqualTo(4);
        assertThat(people.get(0).age).isEqualTo(6);
        assertThat(people.get(1).age).isEqualTo(15);
        assertThat(people.get(2).age).isEqualTo(23);
        assertThat(people.get(3).age).isEqualTo(65);

    }
}