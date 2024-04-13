package 从头打印链表;



import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        //双向链表
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        Stack<String> objects = Main.listPrint(list);
       while (!objects.isEmpty()){
            Object pop = objects.pop();
            System.out.println(pop);
        }
    }
    public static Stack<String> listPrint(LinkedList pHead){
        Iterator iterator = pHead.iterator();
        Stack<String> stack = new Stack<>();
        while (iterator.hasNext()){
            stack.push((String) iterator.next());
        }
        return stack;
    }
}
