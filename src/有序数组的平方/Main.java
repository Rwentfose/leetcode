package 有序数组的平方;

import java.lang.reflect.Array;
import java.util.Arrays;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) {
        int nums[] = {-7,-3,2,3,11};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }
    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0;
        int right =  nums.length - 1;
        int index = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            while(left <= right){
                if(abs(nums[left])*abs(nums[left]) >= abs(nums[right])*abs(nums[right])){
                    result[index--]=nums[left]*nums[left];
                    left++;
                }else {
                    result[index--] = nums[right]*nums[right];
                    right--;
                }
            }
        }
        return result;
    }
}
