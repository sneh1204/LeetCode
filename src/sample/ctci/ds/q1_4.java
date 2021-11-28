package sample.ctci.ds;

import java.util.HashSet;
import java.util.Set;

public class q1_4 {

    public static boolean isPermutationPalindrome(String str){
        Set<Character> store = new HashSet<>();
        for (Character c: str.toCharArray()) if(!store.add(c)) store.remove(c);
        return store.size() <= 1;
    }

    public static void main(String[] args) {
        System.out.println(isPermutationPalindrome("aaa"));
    }
}
