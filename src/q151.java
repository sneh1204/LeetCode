
/**
 *
 * REVERSE WORDS IN A STRING
 *
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters.
 * The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words.
 * The returned string should only have a single space separating the words. Do not include any extra spaces.
 */

public class q151 {

    public static String reverseWords(String s) {
        s = s.trim();
        String[] strArr = s.split( "\\s+");
        String temp;
        int len = strArr.length;
        for (int i = 0; i < len/2; i++) {
            temp = strArr[i];
            strArr[i] = strArr[len - i - 1];
            strArr[len - i - 1] = temp;
        }
        return String.join(" ", strArr);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("    the   sky  is blue   "));
    }
}
