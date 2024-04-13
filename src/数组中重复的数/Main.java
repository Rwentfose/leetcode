package 数组中重复的数;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Main.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3});
        System.out.println(Main.findRepeatNumber2(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
    public static void findRepeatNumber(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> p = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(!count.containsKey(nums[i])){
                count.put(nums[i], 1);
            }else {
                System.out.println(nums[i]);
            }

        }
    }

    public static int findRepeatNumber2(int[] nums) {
        int m = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i){
                if(nums[i]==nums[nums[i]]){
                  return nums[i];
                }
                //交换
                 m = nums[i];
                nums[i] = nums[m];
                nums[m] = m;
            }
        }
        return -1;
    }

}
