package 不修改数组找出重复的数字;

import java.util.Scanner;

/**
 * @author mac
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(Main.findDuplicates(new int[]{2,3,5,4,3,2,6,7}));
    }

    public static int findDuplicates(int[] nums) {
        int start = 1;;
        int end = nums.length - 1;

        while(end>=start){
            int middle = ((end - start) >> 1) +start;
            int count = countRange(nums,start,middle);
            if(start == end){
                if(count > 1){
                    return start;
                } else {
                break;
            }
        }
            if(count>middle-start+1){
                end = middle;
            }else {
                 start = middle + 1;
            }
        }
        return -1;
    }
    static int countRange(int[] sums, int start, int end){
        int count = 0;
        for (int i = 0; i < sums.length; i++) {
            if(sums[i]>start&&sums[i]<=end){
                count++;
            }

        }
        return count;
    }
}
