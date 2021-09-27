/**
 *
 * ADD TWO NUMBERS
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 */

public class q2 {

     public static class ListNode {
            int val;
            ListNode next;

            ListNode() {}
            ListNode(int val) {
                this.val = val;
            }
            ListNode(int val, ListNode next) {
                this.val = val; this.next = next;
            }

         @Override
         public String toString() {
             return "ListNode{" +
                     "val=" + val +
                     ", next=" + next +
                     '}';
         }
     }

    static class Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carry = 0; int sum;
            ListNode dummy = new ListNode(0);
            ListNode result = dummy;
            while(l1 != null || l2 != null){
                sum = carry + (l1 == null?0:l1.val) + (l2 == null?0:l2.val);
                carry = (sum > 9)?1:0;
                sum = sum % 10;
                result = result.next = new ListNode(sum);
                if(l1 != null)   l1 = l1.next;
                if(l2 != null)   l2 = l2.next;
            }
            if(carry == 1)  result.next = new ListNode(carry);
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        ListNode q1 = new ListNode(3, new ListNode(4, new ListNode(5)));
        ListNode q2 = new ListNode(4, new ListNode(0, new ListNode(5)));
        ListNode result = new Solution().addTwoNumbers(q1, q2);
        System.out.println(result);
    }

}
