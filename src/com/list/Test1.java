package src.com.list;

public class Test1 {

    //https://mp.weixin.qq.com/s?__biz=MzUyNjQxNjYyMg==&mid=2247486537&idx=3&sn=0419423daea576756eac87d9f2e55e6c&chksm=fa0e63c8cd79eade3fd20b61ceb8ca8288944b177f96327ae8768894610d0d4c0a819560c7a1&scene=21#wechat_redirect

    //数组去重
    public static void main(String[] args) {
        int[] a = {0, 0, 1, 1, 2, 2, 2, 3, 3, 4};
        int n = removeDuplicate(a);
        for (int i = 0; i < n; i++) {
            System.out.println("------------" + a[i]);
        }
    }

    public static int removeDuplicate(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        int slow = 0, fast = 1;
        while (fast < n) {
            if (arr[slow] != arr[fast]) {
                slow++;
                arr[slow] = arr[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
