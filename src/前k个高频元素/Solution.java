package 前k个高频元素;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>((a,b)->b.getValue() - a.getValue());
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 维护一个大小为k的优先队列
            queue.offer(entry);
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
             res[i]= Objects.requireNonNull(queue.poll()).getKey();
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.topKFrequent(new int[]{4,1,-1,2,-1,2,3}, 2);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}