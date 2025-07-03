package com.autobots.Stream_API;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamAPiLesson {
    public static void main(String[] args) {
        List<String> names = List.of("Anna", "Bob", "Alex", "Bella", "Andrew");

        for (String name : names) {
            if (name.startsWith("A")) {
                System.out.print(name.toUpperCase() + " , ");  //ANNA , ALEX , ANDREW ,
            }
        }
        System.out.println("---------");

        List<String> result = names.stream()
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase)  // Добавим в .map для String::toUpperCase
                .sorted()     // Сортируем
                .collect(Collectors.toList()); // сохранить весь результат
        System.out.println(result);     // результ [ALEX, ANDREW, ANNA]


        // общую сумму выводит
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int r1 = 0;
        for (int num : numbers) {
            r1 += num;
        }
        System.out.println(r1);


        int totalSum = numbers.stream()// от открывает поток и берет доступ к элементам
                .mapToInt(num -> num) // большой Integer в маленький int
                .sum();                // получаем общую сумму чисел
        System.out.println(totalSum);

        int totalElement = (int) numbers.stream()
                .count();
        System.out.println(totalElement);

        numbers.stream()
                .min(Integer::compareTo)
                .ifPresent(System.out::println);

        // Оператор :: в Java называется method reference -это сокращенная форма лямда выражений
        //когда ты просто передаешь существующий метод как функцию.

//        List<String> list = List.of("one", "two", "three", "Hello", "four", "five");
//
//        list.stream()
//                .filter(s -> s.length() > 3)
//                .findFirst()
//                .ifPresent(System.out::println);

        List<Employee> employees = List.of(
                new Employee(1, "Alice", 28, 3000, "IT"),
                new Employee(2, "Bob", 35, 4000, "HR"),
                new Employee(3, "Charlie", 40, 5000, "Finance"),
                new Employee(4, "David", 25, 3500, "IT"),
                new Employee(5, "Eva", 30, 4200, "Marketing"),
                new Employee(6, "Frank", 45, 6000, "Finance"),
                new Employee(7, "Grace", 32, 4100, "HR"),
                new Employee(8, "Henry", 29, 3900, "IT"),
                new Employee(9, "Isabel", 38, 4500, "Marketing"),
                new Employee(10, "Jack", 27, 3600, "IT")
        );
        // 1 Вариант
        List<Employee> itEmployees = employees.stream()
                .filter(s -> s.getDepartment().equals("IT"))
                .collect(Collectors.toList());  // сохранить весь результат
        System.out.println(itEmployees);

        //2 вариант
        List<Employee> itEmployees2 = new ArrayList<>();
       for (Employee employee : employees){
           if (employee.getDepartment().equalsIgnoreCase("IT")){
               itEmployees2.add(employee);
           }
       }
        System.out.println(itEmployees2);
        System.out.println("________________");

        // 1 вариант
        Map<String,List<Employee>> employeesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));//getDepartment из Employee
       // System.out.println(employeesByDepartment);
        //2 вариант
        employeesByDepartment.forEach((department,list)->{
                System.out.println("Отдел " + department);
        list.forEach(System.out::println);
    });

}}
