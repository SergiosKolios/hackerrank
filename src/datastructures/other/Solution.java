package datastructures.other;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("Sergios");
        set.add("Spyros");
        set.add("Aggeliki");

        for (String name : set) {
            System.out.println(name);
        }
    }

}
