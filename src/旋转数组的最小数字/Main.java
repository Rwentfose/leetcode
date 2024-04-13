package 旋转数组的最小数字;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().minNumberInRotateArray(new int[]{3,4,5,1,2}));
    }
    public int  minNumberInRotateArray(int [] array) {
        int left = 0;
        int right = array.length - 1;
        while (left<right){
            int mid = (left+right)/2;
            if(array[mid]<array[right]){
                right = mid;
            }else if(array[mid]>array[right]) {
                left = mid+1;
            }else
                right--;
        }
        return  array[left];
    }
}
