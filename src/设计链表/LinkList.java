package 设计链表;

public class LinkList {
    private Node head;
    private Integer N;

    public class Node<T> {
        T val;
        Node next;

        public Node(T val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public LinkList() {
         Node head = new Node(null, null);
    }

    public int get(int index) {
        Node head = new Node(null, null);
        for (int i = 0; i < N; i++) {
            if (i == index) {
                return (int) head.val;
            }
            head = head.next;
        }
        return -1;
    }

    public void addAtHead(int val) {
        Node head = new Node(null, null);
        // 头插法
        Node node = new Node(val, head);
        // 把新插入的节点作为头节点
        head = node;

    }

    public void addAtTail(int val) {
        Node n = new Node(val, null);
        Node m = head.next;
        while (m != null) {
            m = m.next;
        }
        m.next = n;
        N++;

    }

    public void addAtIndex(int index, int val) {
      Node n =new Node(val,null);
      Node m =head;
        for (int i = 0; i <index; i++) {
            m=m.next;
        }
        n.next=m.next;
        m.next=n;
        N++;
    }

    public void deleteAtIndex(int index) {
       Node m = head;

        for (int i = 0; i < index-1; i++) {
            m=m.next;
        }
        Node curr = m.next;
        Node currNext = curr.next;
        m.next=currNext;
        N--;
    }

}
