package src.com.dynamic;

public class Test3 {

    // 机器人走路 带权重 二维数组DP
    public static void main(String[] args) {
        int[][] arr = {{1,3,1}, {1,5,1}, {4,2,1}};
        int cnt = f(arr);
        System.out.println("---------" + cnt);
    }

    public static int f(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        if (m <= 0 || n <= 0) return 0;

        int[][] dp = new int[m][n];
        dp[0][0] = arr[0][0];

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + arr[i][0];
        }

        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1] + arr[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + "   ");
            }
            System.out.println("   ");
        }

        return dp[m-1][n-1];
    }
}
