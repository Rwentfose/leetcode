package 滑动窗口最大值;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static class MyQueue {
        Deque<Integer> deque = new LinkedList<>();

        public void poll (int val){
            if (!deque.isEmpty() && val == deque.peek()) {
                deque.poll();
            }
        }
        public void add(int val) {
           while (!deque.isEmpty() && deque.peekLast() < val){
               deque.removeLast();
           }
           deque.add(val);
        }
        public int peek() {
            return  deque.peek();
        }

    }
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length == 1) {
                return nums;
            }
            int len = nums.length - k + 1;
            //存放结果元素的数组
            int[] res = new int[len];
            int num = 0;
            //自定义队列
            MyQueue myQueue = new MyQueue();
            //先将前k的元素放入队列
            for (int i = 0; i < k; i++) {
                myQueue.add(nums[i]);
            }
            res[num++] = myQueue.peek();
            for (int i = k; i < nums.length; i++) {
                //滑动窗口移除最前面的元素，移除是判断该元素是否放入队列
                myQueue.poll(nums[i - k]);
                //滑动窗口加入最后面的元素
                myQueue.add(nums[i]);
                //记录对应的最大值
                res[num++] = myQueue.peek();
            }
            return res;
        }

    public static void main(String[] args) {
        new Solution().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }
    }