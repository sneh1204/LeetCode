package sample.fbprep;

public class ValidPalindrome2 {

    public boolean validPalindrome(String s) {
        if(s == null || s.length() <= 2) return true;

        int left = 0, right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else{
                return palindromeHelper(s, left+1, right) || palindromeHelper(s, left, right-1);
            }
        }
        return true;
    }

    public boolean palindromeHelper(String s, int left, int right){
        while(left < right){
            if(s.charAt(left++) != s.charAt(right--)) return false;
        }
         return true;
    }

}
