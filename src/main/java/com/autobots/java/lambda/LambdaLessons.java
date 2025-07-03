package com.autobots.java.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaLessons {
    public static void main(String[] args) {
        MathOperation addition = (a,b) -> a + b;
        MathOperation multi = (a,b) -> a * b;
                                                  //.operation из класса MathOperation
        System.out.println("5 + 3 = " + addition.operation(5,3) );
                                                  //.operation из класса MathOperation
        System.out.println("5 * 3 = " + multi.operation(5,3));

        // он принимает любой обьект и возвращает boolean значение
        Predicate<String> isNotEmpty = s -> !s.isEmpty();
        System.out.println(isNotEmpty.test(""));  // false
        System.out.println(isNotEmpty.test("Java")); // true

        // принимает Integer и возвращает String ->Function<Integer,String> toStringFun
        Function<Integer,String> toStringFun = i -> "Число: " + i;
        System.out.println(toStringFun.apply(10));
         // Consumer ->потреблять
        Consumer<String> print = s -> System.out.println("Writing: " + s);
        print.accept("Hello World");// System.out.println
    }
}


