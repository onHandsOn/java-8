package com.carbonit.java8.functional_interface;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaces {

    private FunctionalInterfaces() {
    }

    public static Function<List<Integer>, Integer> countNbElementFunction() {
        return List::size;
    }

    public static Predicate<String> emptyStringChecker() {
        return String::isEmpty;
    }

    public static Consumer<int []> doubleValue () {

        return (myTabInt) -> {
            for (int i = 0; i < myTabInt.length; i++) {
            myTabInt[i] = myTabInt[i] * 2;
        }};

    }

    public static Supplier<Double> getPiNumber() {
        return ()-> Math.PI;
    }

    public static Supplier<List> getEmptyList() {
        return ArrayList::new;
    }

    public static Consumer<String> addElement(List<String> list) {
        return list::add;
    }

    public static Comparator<String> byStringLengthComparator() {
        return (s1, s2) -> Integer.compare(s1.length(), s2.length());
    }
}
