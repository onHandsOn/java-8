package com.carbonit.java8.files;

import com.carbonit.java8.model.Person;
import org.junit.Test;

import java.net.URI;
import java.util.List;

import static com.carbonit.java8.TestUtils.generateAPerson;
import static org.assertj.core.api.Assertions.assertThat;

public class FilesOperationsTest {

    @Test
    public void should_read_person_in_file() throws Exception {
        // Given
        Person p1 = generateAPerson("Dupont", "Jean", 26);
        Person p2 = generateAPerson("Durant", "Julie", 29);
        Person p3 = generateAPerson("B", "Georges", 35);

        // When
        URI uri = FilesOperations.class.getResource("/people.txt").toURI();
        List<Person> people = FilesOperations.readLinesFromAFile(uri);

        // Then
        assertThat(people).hasSize(3);
        assertThat(people).containsExactly(p1, p2, p3);
    }
}