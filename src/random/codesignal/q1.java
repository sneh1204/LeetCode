package random.codesignal;
/**
 *
 *
 *
 */
public class q1 {

    static boolean isPerfectSquare(int num){
        if(num < 0) return false;
        else if (num < 2) return true;
        long x = num / 2;
        while (x * x > num) x = (x + num / x) / 2;
        return (x * x == num);
    }

    static int no_of_perfect_square_pairs(int[] nums){
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++)
                if(isPerfectSquare(nums[i] + nums[j]))    ++count;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(no_of_perfect_square_pairs(new int[]{-2, -1, 0, 1, 2}));
    }
}
