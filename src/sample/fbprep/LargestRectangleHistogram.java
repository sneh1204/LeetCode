package sample.fbprep;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleHistogram {

    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1); // to keep track of end
        int length = heights.length;
        int maxArea = 0;
        for (int i = 0; i < length; i++) {
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i]){
                int cur = stack.pop();
                maxArea = Math.max(maxArea, heights[cur] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }

        while (stack.peek() != -1){ // elements left, meaning all elements till end have atleast this height
            int cur = stack.pop();
            maxArea = Math.max(maxArea, heights[cur] * (length - stack.peek() - 1));
        }

        return maxArea;
    }

    public static void main(String[] args) {

    }

}
