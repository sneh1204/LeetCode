package sample.fbprep;

public class MinRemoveParenthesis {

    public static String minRemoveToMakeValid(String s) {
        if(s == null || s.length() <= 0) return s;

        int open = 0;
        StringBuilder sb = new StringBuilder();

        for (char c: s.toCharArray()) {
            if(c == '('){
                open++;
            }else if(c == ')'){
                if(open == 0) continue;
                open--;
            }
            sb.append(c);
        }

        if(open == 0) return sb.toString();

        StringBuilder result = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--) {
            if(sb.charAt(i) == '(' && open > 0){
                open--;
                continue;
            }
            result.append(sb.charAt(i));
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
    }

}
