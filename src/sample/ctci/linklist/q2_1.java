package sample.ctci.linklist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class q2_1 {

    public static class ListNode {
        int val;
        ListNode next;

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode removeDuplicates(ListNode head){
        ListNode temp = head;
        HashSet<Integer> set = new HashSet<>();
        ListNode prev = head;
        while(head != null){
            if(!set.add(head.val))
                prev.next = head.next;
            else
                prev = head;
            head = head.next;
        }
        return temp;
    }

    public static ListNode removeDuplicatesConstantSpace(ListNode head){
        ListNode temp = head;

        while(head != null){
            ListNode next = head;
            while(next.next != null){
                if(head.val == next.next.val)
                    next.next = next.next.next;
                else
                    next = next.next;
            }
            head = head.next;
        }

        return temp;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(2);

        System.out.println(removeDuplicatesConstantSpace(head));
    }
}
