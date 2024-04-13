package 删除字符串中所有相邻重复项;

import java.util.Stack;
import java.util.stream.Collectors;

class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty() || stack.peek() != s.charAt(i)){
                stack.push(s.charAt(i));
            }else{
                stack.pop();
            }
        }
        return stack.isEmpty() ? "" : stack.stream().map(Object::toString).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates("abbaca"));
    }
}        // 输出 "ca"