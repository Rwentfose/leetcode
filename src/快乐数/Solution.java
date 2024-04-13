package 快乐数;

import java.util.HashSet;
import java.util.Set;
class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        while (slow!= 1 && fast != 1){
            slow = getNext(slow);
            fast = getNext(getNext(fast));
            //如果两个指针相遇，说明有环，不是快乐数
        if (slow == fast && slow != 1){
                return false;
            }
        }
        return true;
    }
    public  int getNext(int n){
        int res = 0;
        while (n>0){
            res =  res + (n%10)*(n%10);
            n = n/10;
        }
        return res;
    }

    public static void main(String[] args) {
        new  Solution().isHappy(10);
    }
}