package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Fibonoci {

    static class Employee{
        private final int id;
        private final String name;

        public Employee(int id, String name){
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return this.id + " :: " + this.name;
        }
    }

    private static List<Employee> getEmployees(){
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Vishnu"));
        employees.add(new Employee(2, "Ganta"));
        employees.add(new Employee(3, "Google"));
        employees.add(new Employee(4, "AWS"));
        employees.add(new Employee(5, "FB"));
        employees.add(new Employee(6, "Apple"));
        employees.add(new Employee(7, "Bat"));
        employees.add(new Employee(8, "Emp"));
        employees.add(new Employee(9, "Test"));
        employees.add(new Employee(10, "Test1"));

        employees.sort(Comparator.comparing(o -> o.name));
        return employees;
    }

    public static void main(String[] args){
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(0);
//        list.add(1);
//
//        for(int i = 2; i < 10; i++){
//            list.add(list.get(i - 1) + list.get(i - 2));
//        }
//        System.out.println(list);
        System.out.println(getEmployees());
    }
}
