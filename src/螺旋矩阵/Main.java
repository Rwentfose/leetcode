package 螺旋矩阵;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] ints = generateMatrix(4);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[i][j]+"  ");
            }
            System.out.println();
        }
    }
    public static int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int loop = 0;
        int startx = 0;
        int count = 1;
        int i,j;
      while (loop++<n/2){
          for ( j = startx; j < n-loop; j++) {
              nums[startx][j]=count++;
          }
          for ( i = startx; i < n-loop; i++) {
              nums[i][j] = count++;
          }
          for (; j >= loop; j--) {
              nums[i][j] = count++;
          }
          for (; i >= loop; i--){
              nums[i][j] = count++;
          }
          startx++;
      }
   if (n%2 == 1){
       nums[startx][startx] = count;
   }
   return nums;
    }
}
