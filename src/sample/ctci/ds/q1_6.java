package sample.ctci.ds;

import java.util.HashMap;
import java.util.Map;

public class q1_6 {

    public static String compression(String str){
        StringBuilder sb = new StringBuilder();

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count++;

            if(i >= str.length() - 1 || str.charAt(i) != str.charAt(i + 1)){
                sb.append(str.charAt(i)).append(count);
                count = 0;
            }
        }

        return sb.length() < str.length() ? sb.toString() : str;
    }

    public static void main(String[] args) {
        System.out.println(compression("aabbbcccddd"));
    }
}
