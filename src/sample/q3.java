package sample;

import sample.q3.ListNode;

public class q3 {

    // TC - O(N)
    // SC - O(1)

    public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;

        ListNode middle = getMiddleNode(head);
        ListNode afterMiddle = reverse(middle.next);

        boolean check = true;
        while (check && afterMiddle != null){
            if(head.val != afterMiddle.val) check = false;
            afterMiddle = afterMiddle.next;
            head = head.next;
        }

        return check;
    }

    public ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public ListNode getMiddleNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {

    }

}
