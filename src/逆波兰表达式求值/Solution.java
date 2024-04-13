package 逆波兰表达式求值;

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                int  b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                int res = 0;
                if(tokens[i].equals("+")){
                    res = a + b;
                }else if(tokens[i].equals("-")){
                    res = a - b;
                }else if(tokens[i].equals("*")){
                    res = a * b;
                }else{
                    res = a / b;
                }
                stack.push(String.valueOf(res));
            }else {
                stack.push(tokens[i]); // 数字直接入栈
            }
        }
        return  Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        int i = new Solution().evalRPN(new String[]{"2", "1", "+", "3", "*"});
        System.out.println(i);
    }
}