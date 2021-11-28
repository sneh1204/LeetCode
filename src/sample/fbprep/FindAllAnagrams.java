package sample.fbprep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagrams {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> output = new ArrayList<>();
        HashMap<Character, Integer> pStore = new HashMap<>();

        for (Character c: p.toCharArray()) {
            pStore.put(c, pStore.getOrDefault(c, 0) + 1);
        }

        // s = cbaebabacd
        // p = abc

        int match = 0, start = 0, end = 0;

        while(end < s.length()){
            Character curr = s.charAt(end);

            // incoming
            if(pStore.containsKey(curr)){
                pStore.put(curr, pStore.get(curr) - 1);

                if(pStore.get(curr) == 0){
                    match++;
                }

            }

            // outgoing
            if(end - start + 1 > p.length()){
                Character first = s.charAt(start);
                if(pStore.containsKey(first)){
                    pStore.put(first, pStore.get(first) + 1);

                    if(pStore.get(first) == 1) match--;
                }
                start++;
            }

            if(match == pStore.size()){
                output.add(start);
            }

            end++;

        }

        return output;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }

}
