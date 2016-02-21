package com.carbonit.java8.functional_interface;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionalInterfacesTest {

    @Test
    public void should_count_elememt_from_list() {
        // Given
        List<Integer> myList = Arrays.asList(1, 2, 2, 3, 4, 5);

        // When
        Function<List<Integer>, Integer> listIntegerFunction =
                FunctionalInterfaces.countNbElementFunction();
        Integer result = listIntegerFunction.apply(myList);

        // Then
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void should_test_empty_string() {
        // Given
        Predicate<String> isEmptyString = FunctionalInterfaces.emptyStringChecker();

        // When - Then
        assertThat(isEmptyString.test("myString")).isFalse();
        assertThat(isEmptyString.test("")).isTrue();
    }

    @Test
    public void should_double_value_from_tab() {
        // Given
        int[] myArray = new int[] {1, 2, 3, 4};

        // When
        Consumer<int[]> consumer = FunctionalInterfaces.doubleValue();
        consumer.accept(myArray);

        // Then
        assertThat(myArray).isEqualTo(new int[]{2, 4, 6, 8});
    }

    @Test
    public void should_get_pi_number() {
        // Given
        Supplier<Double> supplier = FunctionalInterfaces.getPiNumber();

        // When
        Double piNumber = supplier.get();

        // Then
        assertThat(piNumber).isEqualTo(Math.PI);
    }

    @Test
    public void shoulg_get_empty_list() {
        // Given
        Supplier<List> supplier = FunctionalInterfaces.getEmptyList();

        // When
        List emptyList = supplier.get();

        // Then
        assertThat(emptyList).isNotNull();
        assertThat(emptyList).isEmpty();
    }

    @Test
    public void should_add_element() {
        // Given
        List<String> list = new ArrayList<>();
        Consumer<String> consumer = FunctionalInterfaces.addElement(list);

        // When
        consumer.accept("first");
        consumer.accept("second");

        // Then
        assertThat(list).containsExactly("first", "second");
    }

    @Test
    public void should_compare_string_size() {
        // Given
        String[] value = {"a", "bcde", "fg", "h", "ijklmn"};

        // When
        Arrays.sort(value, FunctionalInterfaces.byStringLengthComparator());

        // Then
        assertThat(value).containsExactly("a", "h", "fg", "bcde", "ijklmn");
    }
}