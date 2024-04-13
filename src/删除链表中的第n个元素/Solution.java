package 删除链表中的第n个元素;


public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode fast = null;
      ListNode slow = null;
      ListNode dmyHand =  new ListNode(0,head);
      fast = slow =  dmyHand;
      for(int i = 1;i<=n+1;i++){
          fast = fast.next;
      }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dmyHand.next;
    }
   static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}