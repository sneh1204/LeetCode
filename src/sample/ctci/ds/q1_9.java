package sample.ctci.ds;

public class q1_9 {

    public static boolean stringRotation(String str, String str2){
        String joined = str2 + str2;
        return joined.contains(str);
    }

    public static void main(String[] args) {
        System.out.println(stringRotation("waterbottle", "erbottlewat"));
    }

}
