package sample.ctci.ds;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class q1_2 {

    public static boolean isPermutation(String s1, String s2){
        if(s1.length() != s2.length()) return false;

        HashMap<Character, Integer> store = new HashMap<>(); // could use int array too

        for (Character c : s1.toCharArray()){
            store.put(c, store.getOrDefault(c, 0) + 1);
        }

        for (Character c:
             s2.toCharArray()) {
            store.put(c, store.getOrDefault(c, 0) - 1);
            if(store.get(c) <= -1) return false;
        }

        return true;

    }

    public static void main(String[] args) {
        System.out.println(isPermutation("ascii", "aisci"));
        System.out.println(isPermutation("ascii", "aici"));
    }
}
