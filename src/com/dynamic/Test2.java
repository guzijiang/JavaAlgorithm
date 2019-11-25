package src.com.dynamic;

public class Test2 {

    // 机器人走路 二维数组DP
    public static void main(String[] args) {
        int cnt = f(3, 3);
        System.out.println("---------" + cnt);
    }

    public static int f(int m, int n) {
        if (m <= 0 || n <= 0) return 0;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}
