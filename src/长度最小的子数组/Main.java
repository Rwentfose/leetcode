package 长度最小的子数组;

public class Main {
    public static void main(String[] args) {
    int nums[]={1,4,4};
    int target = 4;
   ;
        System.out.println( minSubArrayLen(target,nums));
    }
//    public static int minSubArrayLen(int target, int[] nums) {
//        int size=100000;
//        int countList= 0 ;
//        for (int i = 0; i < nums.length; i++) {
//            int count = 0;
//            long sum= 0 ;
//            for (int j = i; j<nums.length; j++) {
//                sum+=nums[j];
//                count++;
//               if(sum>=target){
//                   if(count<=size){
//                       size=count;
//                   }
//                   countList++;
//                   break;
//                }
//            }
//        }
//        if(countList==0){
//            size=0;
//        }
//
//
//        return size;
//    }
    // 优化，滑动窗口
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0 ;
        int right = 0 ;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum+nums[right++];
            while (sum>=target){
                result = Math.min(result,right-left+1);
                sum = sum- nums [left++];
            }
        }
        return  result==Integer.MAX_VALUE?0:result;
    }
}
