package sample.fbprep;

public class TrappingRainWater {
    
    // TC - O(N)
    // SC - O(1)


    public int trap(int[] height) {
        if(height == null || height.length <= 1) return 0;
        int area = 0, leftmax = 0, rightmax = 0, left = 0, right = height.length - 1;
        while(left < right){
            leftmax = Math.max(leftmax, height[left]);
            rightmax = Math.max(rightmax, height[right]);
            if(leftmax < rightmax){
                area += leftmax - height[left];
                left++;
            }else{
                area += rightmax - height[right];
                right--;
            }
        }
        return area;
    }

}
