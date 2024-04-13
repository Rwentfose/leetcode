package 相交链表;

import common.ListNode;

import java.util.Stack;

public class Solution {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        int aCount = 0, bCount = 0, diff = 0;
        while (A != null) {
            aCount++;
            A = A.next;
        }
        while (B != null) {
            bCount++;
            B = B.next;
        }
        diff = aCount - bCount;
        if (diff > 0) {
            for (int i = 0; i < Math.abs(diff); i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < Math.abs(diff); i++) {
                headB = headB.next;
            }
        }
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public static ListNode getIntersectionNodeStack(ListNode headA, ListNode headB) {
        Stack<ListNode> listNodeA = new Stack<>();
        Stack<ListNode> listNodeB = new Stack<>();
        while (headA != null){
            listNodeA.push(headA);
            headA = headA.next;
        }
        while (headB != null){
            listNodeB.push(headB);
            headB = headB.next;
        }
        ListNode result = null;
        while (!listNodeA.isEmpty() && !listNodeB.isEmpty()){
            ListNode nodeA = listNodeA.pop();
            ListNode nodeB = listNodeB.pop();
            if(nodeA == nodeB){
                result = nodeA;
            }else {
                break;
            }
        }
        return result;
    }
}