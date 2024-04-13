package 用栈实现队列;

import java.util.Objects;
import java.util.Stack;

class MyQueue {
    Stack<Object> stackA;
    Stack<Object> stackB ;
    public MyQueue() {
      stackA = new Stack<>();
      stackB = new Stack<>();
    }
    
    public void push(int x) {
       stackA.push(x);
    }
    
    public int pop() {
        if(stackB.isEmpty()){
            while(!stackA.isEmpty()){
                stackB.push(stackA.pop());
            }
        }
        return (int) stackB.pop();
    }
    
    public int peek() {
    if(stackB.isEmpty()){
        while (!stackA.isEmpty()){
            stackB.push(stackA.pop());
        }
    }
    return (int) stackB.peek();
    }
    
    public boolean empty() {
    return stackB.isEmpty() && stackA.isEmpty();
    }
}
