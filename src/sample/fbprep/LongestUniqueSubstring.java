package sample.fbprep;

import java.util.HashMap;

public class LongestUniqueSubstring {

    // TC - O(N)
    // SC - O(1) Only 26

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() <= 0) return 0;

        int max = 0;
        HashMap<Character, Integer> store = new HashMap<>();
        int start = 0, end = 0;

        while(end < s.length()) {
            Character current = s.charAt(end);

            if(store.containsKey(current))
                start = Math.max(start, store.get(current));

            max = Math.max(max, end - start + 1);
            store.put(current, end + 1);
            end++;

        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("zbxybcba"));
    }

}
