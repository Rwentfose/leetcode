package 反转链表;

public class Main {


    static class ListNode {
     int val;
     ListNode next;
     ListNode() {}ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  static   class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode cur = head;
            ListNode prev = null;
            ListNode  tmp = null;
            while (cur != null){
                tmp = cur.next;
                cur.next = prev;
                // 更新指针
                prev = cur;
                cur = tmp;
            }
            return  prev;
        }
    }

    public static void main(String[] args) {
        Main.Solution solution = new Main.Solution();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode1 = solution.reverseList(listNode);
        while (listNode1.next!=null){
            System.out.println(listNode1.val);
            listNode1 =  listNode1.next;
        }
    }
}
