package 两两交换链表中的节点;

public class Main {


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //递归
    public ListNode swapPairs(ListNode head) {
        if ( head == null ||head.next == null){
            return head;
        }
        ListNode next = head.next;
        //递归交换剩余的节点
        ListNode newNode = swapPairs(next.next);
        next.next = head;
        head.next = newNode;
        return next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        Main main = new Main();
        ListNode newHead = main.swapPairs(head);
        System.out.println(newHead);
    }

}
