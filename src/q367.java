/**
 *
 * VALID PERFECT SQAURES
 *
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Follow up: Do not use any built-in library function such as sqrt.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 16
 * Output: true
 * Example 2:
 *
 * Input: num = 14
 * Output: false
 */

public class q367 {


    static boolean isPerfectSquare(int num, Modes mode){
        if(num < 0) return false;
        else if (num < 2) return true;
        if(mode == Modes.TWO_POINTER) {
            long start = 2, end = num / 2, picked_no, square;
            while (start <= end) {
                picked_no = start + (end - start) / 2;
                square = picked_no * picked_no;
                if (square == num) return true;
                if (square > num) end = picked_no - 1;
                else start = picked_no + 1;
            }
            return false;
        }else if(mode == Modes.SQRT){
            double square = Math.sqrt(num);
            return (square - Math.floor(square)) == 0;
        }else if(mode == Modes.NEWTONS){

            long x = num / 2;
            while (x * x > num) x = (x + num / x) / 2;
            return (x * x == num);
        }
        return false;
    }

    enum Modes{
        TWO_POINTER, NEWTONS, SQRT
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(126, Modes.NEWTONS));
    }

}
