package 移除链表元素;

import java.util.LinkedList;

public class Main {

   private class Node<T>{
       Integer data;
       Node next;

       public Node(Integer data, Node next) {
           this.data = data;
           this.next = next;
       }
   }
    public  Node removeElements(Node head, int val) {
       if(head==null){
           return head;
       }
       Node pre= head;
       Node preDID=new Node(null,null);
       Node preNext=new Node(null,null);
       preDID.next=pre;
       preNext=pre.next;
       while(pre.next!=null){
           if(pre.data==val){
               preDID.next=preNext;
           }
           pre=pre.next;
       }
       return head;
    }

    public static void main(String[] args) {
        Main main = new Main();


    }
}
