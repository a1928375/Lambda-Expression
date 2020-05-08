package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//
//                String myString = "Let's split this up into an array";
//                String[] parts = myString.split(" ");
//                for (String part: parts) {
//                    System.out.println(part);
//                }
//
//            }
//        };

        Runnable runnable = () -> {

            for (String part: "Let's split this up into an array".split(" ")) {
                System.out.println(part);
            }
        };

        runnable.run();

        System.out.println("-----------------------------------------------------");

        Function <String, String> lambdaFunction = s -> {

            StringBuilder returnVal = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {

                if (i%2==1) {

                    returnVal.append(s.charAt(i));
                }
            }

            return returnVal.toString();

        };

        System.out.println(lambdaFunction.apply("1234567890"));

        System.out.println("-----------------------------------------------------");

        System.out.println(everySecondChar(lambdaFunction, "1234567890"));

        System.out.println("-----------------------------------------------------");

        Supplier<String> iLoveJava = () -> "I love Java!";

        String supplierResult = iLoveJava.get();

        supplierResult.indexOf(0);

        System.out.println(supplierResult);

        System.out.println("-----------------------------------------------------");

        List<String> topNames2015 = Arrays.asList (

                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        List<String> temp = topNames2015
                .stream()
                .map(s -> (s.substring(0,1).toUpperCase() + s.substring(1)))
                .sorted()
                .collect(Collectors.toList());

        for (String s : temp) {

            System.out.println(s);
        }

        System.out.println("-----------------------------------------------------");

        topNames2015
                .stream()
                .map(s -> (s.substring(0, 1).toUpperCase() + s.substring(1)))
                .sorted()
                .forEach(System.out::println);

        System.out.println("-----------------------------------------------------");

        long temp2 =  topNames2015
                .stream()
                .filter(s -> s.startsWith("A"))
                .count();

            System.out.println("Number of names beginning with 'A' is: " + temp2);

        System.out.println("-----------------------------------------------------");

        List<String> temp1 = new ArrayList<>();

        topNames2015.forEach(s ->
                temp1.add(s.substring(0,1).toUpperCase() + s.substring(1)));

//        temp1.sort((s1,s2) -> s1.compareTo(s2));
        temp1.sort(String::compareTo);

//        temp1.forEach(i -> System.out.println(i));
        temp1.forEach(System.out::println);

        System.out.println("-----------------------------------------------------");

        topNames2015
                .stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .peek(System.out::println)
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        System.out.println("-----------------------------------------------------");

        long temp3 = topNames2015
                .stream()
                .count();

        System.out.println(temp3);

    }

//    public static String everySecondChar (String source) {
//
//        StringBuilder returnVal = new StringBuilder();
//
//        for (int i = 0; i < source.length(); i++) {
//
//            if (i%2==1) {
//
//                returnVal.append(source.charAt(i));
//            }
//        }
//
//        return returnVal.toString();
//    }


    public static String everySecondChar (Function lambda, String string) {

        return (String) lambda.apply(string);

    }
}
