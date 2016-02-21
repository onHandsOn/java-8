package com.carbonit.java8.collections;

import com.carbonit.java8.TestUtils;
import com.carbonit.java8.model.Person;
import com.carbonit.java8.model.Student;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.carbonit.java8.TestUtils.*;
import static com.carbonit.java8.collections.StreamOperations.*;
import static com.carbonit.java8.model.PersonBuilder.aPersonBuilder;
import static com.carbonit.java8.model.StudentBuilder.aStudentBuilder;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StreamOperationsTest {

    @Test
    public void should_create_list_of_six_elements() throws Exception {
        // Given - When
        List<Integer> result = buildNumberList(6);

        //Then
        assertThat(result).hasSize(6);
        assertThat(result).containsExactly(1 ,2 ,3 ,4 ,5 ,6);
    }

    @Test
    public void should_filter_on_even_element_in_a_list() throws Exception {
        // Given
        List<Integer> myList = asList(2,55,68, 102, 87, 7, 5, 2, -2);

        // When
        List<Integer> result = filterOnEvenNumber(myList);

        //Then
        assertThat(result).hasSize(5);
        assertThat(result).containsExactly(2, 68, 102, 2 , -2);
    }

    @Test
    public void should_group_by_age() throws Exception {
        // Given
        Person person1 = generateAPerson("Dupont", "John", 33);
        Person person2 = generateAPerson("Blanc", "Michel", 28);
        Person person3 = generateAPerson("Palmade", "Pierre", 33);
        Person person4 = generateAPerson("Durant", "Jeanne", 65);
        Person person5 = generateAPerson("Lamy", "Alexandra", 28);

        // When
        Map<Integer, List<Person>> map = groupingByAge(asList(person1, person2,
                person3, person4, person5));

        //Then
        assertThat(map).hasSize(3);
        assertThat(map).containsOnlyKeys(28, 33, 65);
        assertThat(map.get(28)).isEqualTo(asList(person2, person5));
        assertThat(map.get(33)).isEqualTo(asList(person1, person3));
        assertThat(map.get(65)).isEqualTo(asList(person4));

    }

    @Test
    public void should_find_the_papy_person() throws Exception {
        // Given
        Person person1 = generateAPerson("Dupont", "John", 33);
        Person person2 = generateAPerson("Blanc", "Michel", 28);
        Person person3 = generateAPerson("Palmade", "Pierre", 33);
        Person person4 = generateAPerson("Durant", "Jeanne", 65);
        Person person5 = generateAPerson("Lamy", "Alexandra", 28);

        // When
        Person olderPerson = findOlderPerson(asList(person1, person2,
                person3, person4, person5));

        //Then
        assertThat(olderPerson).isEqualTo(person4);
        assertThat(olderPerson.age).isEqualTo(65);

    }

    @Test
    public void should_find_students() throws Exception {
        // Given
        Person person1 = generateAPerson("Dupont", "John", 13);
        Person person2 = generateAPerson("Blanc", "Michel", 18);
        Person person3 = generateAPerson("Palmade", "Pierre", 33);
        Person person4 = generateAPerson("Durant", "Jeanne", 25);
        Person person5 = generateAPerson("Lamy", "Alexandra", 28);

        // When
        List<Student> students = findStudents(asList(person1, person2,
                person3, person4, person5));

        //Then
        assertThat(students).hasSize(3);
    }

    @Test
    public void should_count_students() throws Exception {
        // Given
        Person person1 = generateAPerson("Dupont", "John", 13);
        Person person2 = generateAPerson("Blanc", "Michel", 18);
        Person person3 = generateAPerson("Palmade", "Pierre", 33);
        Person person4 = generateAPerson("Durant", "Jeanne", 25);
        Person person5 = generateAPerson("Lamy", "Alexandra", 28);

        // When
        int countNbStudents = countNbStudents(asList(person1, person2,
                person3, person4, person5));

        //Then
        assertThat(countNbStudents).isEqualTo(3);
    }

    @Test
    public void should_find_a_student() throws Exception {
        // Given
        Person person1 = generateAPerson("Dupont", "John", 13);
        Person person2 = generateAPerson("Blanc", "Michel", 18);
        Person person3 = generateAPerson("Durant", "Jeanne", 15);
        Person person4 = generateAPerson("Lamy", "Alexandra", 17);

        // When
        Student student = addAYearAndGetFirstStudent(asList(person1, person2,
                person3, person4));

        //Then
        assertThat(student).isNotNull();
        assertThat(student.age).isGreaterThanOrEqualTo(18);
        assertThat(student.lastName).isEqualTo("Blanc");
        assertThat(student.firstName).isEqualTo("Michel");
    }

    @Test(expected = Exception.class)
    public void should_not_find_a_student() throws Exception {
        // Given
        Person person1 = generateAPerson("Dupont", "John", 3);
        Person person2 = generateAPerson("Blanc", "Michel", 11);
        Person person3 = generateAPerson("Durant", "Jeanne", 15);
        Person person4 = generateAPerson("Lamy", "Alexandra", 7);

        // When - Then
        addAYearAndGetFirstStudent(asList(person1, person2,
                person3, person4));

    }

    @Test
    public void should_calculate_average_age() throws Exception {
        // Given
        Person person1 = generateAPerson("Dupont", "John", 5);
        Person person2 = generateAPerson("Blanc", "Michel", 15);
        Person person3 = generateAPerson("Durant", "Jeanne", 20);
        Person person4 = generateAPerson("Lamy", "Alexandra", 30);

        // When
        Double averageAge = getAverageAge(asList(person1, person2,
                person3, person4));

        //Then
        assertThat(averageAge).isEqualTo(17.5);

    }

    @Test
    public void should_return_list_of_development_langage() throws Exception {
        //Given
        Student s1 = generateStudent("Davant", "Noemie", 29, Arrays.asList("Java", "Scala"));
        Student s2 = generateStudent("Delprat", "Jean", 39, Arrays.asList("Java", "Scala", "Clojure", "Haskhell"));
        Student s3 = generateStudent("Dupont", "Francois", 29, Arrays.asList("Python", "Ruby", "Node"));

        // When
        List<String> distinctDevelopmentLangages = getDistinctDevelopmentLangages(Arrays.asList(s1, s2, s3));

        // Then
        assertThat(distinctDevelopmentLangages).hasSize(7);
        assertThat(distinctDevelopmentLangages).containsOnly("Java", "Scala", "Clojure", "Haskhell", "Python", "Ruby", "Node");
    }
}