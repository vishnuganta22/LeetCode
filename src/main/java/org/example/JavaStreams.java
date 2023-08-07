package org.example;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class JavaStreams {
    public static void main(String[] args){
        List<Integer> list = Stream.iterate(0, integer -> integer + 1).limit(10).toList();
        Stream.iterate(new int[]{0, 1}, ints -> new int[]{ints[1], ints[0] + ints[1]}).limit(10).map(n -> n[0]).forEach(System.out::println);
        System.out.println(Stream.iterate(new int[]{0, 1}, ints -> new int[]{ints[1], ints[0] + ints[1]}).limit(10).map(n -> n[0]).mapToInt(n -> n).sum());
        System.out.println(list);
    }
}
