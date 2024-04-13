package 剪绳子;

public class Main {

    //剪绳子
    public int maxProductCutting(int n) {
        if (n <= 1) {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[1] = 0; // 1 米绳子不剪
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                max = Math.max(max, Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
            }
            dp[i] = max;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.maxProductCutting(8));
    }
}

