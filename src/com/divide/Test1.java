package src.com.divide;

public class Test1 {

    //https://mp.weixin.qq.com/s?__biz=MzUyNjQxNjYyMg==&mid=2247485228&idx=1&sn=9f48aee51dcb2b98b56b1827cc658439&chksm=fa0e68adcd79e1bbcd0183ef30a79ede4e46c5835ce05ee6644169c3cc9454073019ccd85d3d&scene=21#wechat_redirect

    //归并排序 分治法
    public static void main(String[] args) {
        int[] a = {6, 4, 3, 7, 5, 1, 2};
        int length = a.length;
        mergeSort(a, 0, length - 1);
        for (int i = 0; i < length; i++) {
            System.out.println("------------" + a[i]);
        }
    }

    public static void merge(int[] a, int left, int mid, int right) {
        int[] tmp = new int[a.length];
        int p1 = left, p2 = mid + 1, k = left;
        while (p1 <= mid && p2 <= right) {
            if (a[p1] <= a[p2]) {
                tmp[k++] = a[p1++];
            } else {
                tmp[k++] = a[p2++];
            }
        }
        while (p1 <= mid) tmp[k++] = a[p1++];
        while (p2 <= right) tmp[k++] = a[p2++];

        for (int i = left; i <= right; i++) {
            a[i] = tmp[i];
        }
    }

    public static void mergeSort(int[] a, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(a, start, mid);
            mergeSort(a, mid + 1, end);
            merge(a, start, mid, end);
        }
    }
}
