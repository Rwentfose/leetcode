package 回溯法.机器人的运动范围;

public class Main {
    //机器人的运动范围
    int n;
    int m;
    boolean visited[][];
    public int moveCount(int m,int n,int k){
        this.m = m;
        this.n = n;
        visited = new boolean[m][n];
        return def(0,0,k);

    }

    int def(int i,int j,int k){
        if(i<0||i>=m||j<0||j>=n||visited[i][j]||sum(i)+sum(j)>k){
            return  0;
        }
        visited[i][j] = true;
        return 1+def(i-1,j,k)+def(i+1,j,k)+def(i,j-1,k)+def(i,j+1,k);
    }
     public int sum(int num){
        int res = 0;
        while (num!=0){
            res = res +num%10;
            num = num / 10;
        }
        return res;
     }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println( main.moveCount(3,3,18));
    }
}
