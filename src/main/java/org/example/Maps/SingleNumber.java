package org.example.Maps;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SingleNumber {
    static class Solution {
        public int singleNumber(int[] nums) {

            if(nums.length == 1) return nums[0];

            int a = 0;
            for(int i = 0; i < nums.length; i++){
                a ^= nums[i];
            }
            return a;
        }
    }

    public static void main(String[] args){
        String[] arr = new String[]{"vishnu", "ganta", "hello", "world"};
        List<String> result = Arrays.stream(arr).map(String::toUpperCase).toList();
        List<String> r = result.stream().flatMap((data) -> Arrays.stream(data.split(""))).toList();
        System.out.println(r);

        Stream<String> s1 = Stream.of("Vishnu");
        Stream<String> s2 = Stream.of("Ganta");

        String s3 = Stream.concat(s1, s2).reduce("", (s, d) -> {
            if(s.isEmpty()) return d;
            else return s + " " + d;
        });

        Stream.Builder<String> builder = Stream.builder();
        Stream<String> stream = builder.add("Vishnu").build();

        System.out.println(s3);
    }
}
