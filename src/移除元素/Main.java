package 移除元素;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int nums[]={3,2,2,3};
        int val = 3;
        System.out.println(removeElement(nums,val));
    }
    public static int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count]=nums[i];
                        count++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return count;
    }
}
