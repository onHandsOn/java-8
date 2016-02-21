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
        //TODO: replace with lambda syntax
        return new Function<List<Integer>, Integer>() {
            @Override
            public Integer apply(List<Integer> lists) {
                return lists.size();
            }
        };
    }

    public static Predicate<String> emptyStringChecker() {
        //TODO: replace with lambda syntax
        return new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.isEmpty();
            }
        };
    }

    public static Consumer<int []> doubleValue () {
        //TODO: replace with lambda syntax
        return new Consumer<int[]>() {
            @Override
            public void accept(int[] tabInt) {
                for (int i = 0; i < tabInt.length; i++) {
                    tabInt[i] = tabInt[i] * 2;
                }
            }
        };
    }

    public static Supplier<Double> getPiNumber() {
        //TODO: replace with lambda syntax
        return new Supplier<Double>() {
            @Override
            public Double get() {
                return Math.PI;
            }
        };
    }

    public static Supplier<List> getEmptyList() {
        //TODO: replace with Reference to a constructor
        return new Supplier<List>() {
            @Override
            public List get() {
                return new ArrayList<>();
            }
        };
    }

    public static Consumer<String> addElement(List<String> list) {
        //TODO: replace with instance method reference
        return new Consumer<String>() {
            @Override
            public void accept(String s) {
                list.add(s);
            }
        };
    }

    public static Comparator<String> byStringLengthComparator() {
        //TODO: replace with lambda syntax
        return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        };
    }
}
