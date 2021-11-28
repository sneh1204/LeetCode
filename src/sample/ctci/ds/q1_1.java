package sample.ctci.ds;

public class q1_1 {

    public static boolean isUniqueString(String str){
        if(str.length() > 256) return false; // ASCII

        boolean[] store = new boolean[256];

        for(Character c : str.toCharArray()){
            if(store[c]) return false;
            store[c] = true;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUniqueString("ascii"));
        System.out.println(isUniqueString("asci"));
    }
}
