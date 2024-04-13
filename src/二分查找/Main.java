package 二分查找;

public class Main {
    public static void main(String[] args) {
        int arr[] = {-1, 0, 3, 5, 9, 12};
        int target = 9;

        System.out.println(search(arr, target));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int zj = (right + left) / 2;
            if (nums[zj] < target) {
                left = zj + 1;
            } else if (nums[zj] > target) {
                right = zj - 1;
            } else
                return zj;
        }
        return -1;
    }

}
