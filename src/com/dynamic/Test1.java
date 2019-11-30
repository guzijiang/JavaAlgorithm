package src.com.dynamic;

public class Test1 {

    //https://zhuanlan.zhihu.com/p/91582909?hmsr=toutiao.io&utm_medium=toutiao.io&utm_source=toutiao.io
    //第一步骤：定义数组元素的含义
    //第二步骤：找出数组元素之间的关系式
    //第三步骤：找出初始值

    //小青蛙跳台阶 一维数组DP
    public static void main(String[] args) {
        int cnt = f(5);
        System.out.println("---------" + cnt);
    }

    public static int f(int n) {
        if (n <= 2) return n;

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
