package 二维数组中的查找;

/**
 * @author mac
 */
public class Main {

    public static void main(String[] args) {
        Main.findNumberIn2DArray(new int [][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}},4,4,7);
    }
    public static boolean findNumberIn2DArray(int[][] matrix, int rows, int columns, int number) {
       int row=0;
       int column=columns-1;
        while (row<rows && columns > 0){
           if(matrix[row][column] == number){
               System.out.println("row:"+row+"  column:"+column);
               return true;
           }else if(matrix[row][column] > number){
               column--;
           }else {
               row++;
           }
       }
        System.out.println("没有找到");
        return  false;
    }
}
