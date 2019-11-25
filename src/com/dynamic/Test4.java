package src.com.dynamic;

public class Test4 {

    // 机器人走路 二维数组DP
    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        int cnt = f(word1, word2);
        System.out.println("---------" + cnt);
    }

    public static int f(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];
        dp[0][0] = 0;

        for (int j = 1; j <= n2; j++) {
            dp[0][j] = dp[0][j-1] + 1;
        }

        for (int i = 1; i <= n1; i++) {
            dp[i][0] = dp[i-1][0] + 1;
        }

        for (int i = 1; i <= n1; i++) { // h o r s e
            for (int j = 1; j <= n2; j++) { // r o s
                // h o r
                // r o s
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
            }
        }

        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                System.out.print(dp[i][j] + "   ");
            }
            System.out.println("   ");
        }
        return dp[n1][n2];
    }
}
