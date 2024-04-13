package 环形链表;

import common.ListNode;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                ListNode ptr = head;
                while (ptr != slow){
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return slow;
            }

        }
            return  null;
    }
}