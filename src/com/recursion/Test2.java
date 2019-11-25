package src.com.recursion;

public class Test2 {

    // 小青蛙跳台阶
    public static void main(String[] args) {
        int cnt = f(5);
        System.out.println("---------" + cnt);
    }

    public static int f(int n) {
        if (n <= 2) return n;
        return f(n - 1) + f(n-2);
    }
}
