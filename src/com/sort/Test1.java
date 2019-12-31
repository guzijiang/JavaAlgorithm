package src.com.sort;

public class Test1 {

    //https://mp.weixin.qq.com/s?__biz=MzUyNjQxNjYyMg==&mid=2247484184&idx=1&sn=62965b401aa42107b3c17d1d8ea17454&chksm=fa0e6c99cd79e58f298e9026f677f912bd8c8e55edb48fc509b2b5834f05e529a9b47d59d202&scene=21#wechat_redirect
    //https://www.cnblogs.com/klguang/p/5422877.html 堆排序理解

    //堆排序
    public static void main(String[] args) {
        int[] a = {6, 4, 3, 7, 5, 1, 2, 9, 8, 12};
        int length = a.length;
        heapSort(a);
        for (int i = 0; i < length; i++) {
            System.out.println("------------" + a[i]);
        }
    }

    public static void heapSort(int[] sourceArray) {
        int len = sourceArray.length;

        buildMaxHeap(sourceArray, len);

        for (int i = len - 1; i > 0; i--) {
            swap(sourceArray, 0, i);
            heapify(sourceArray, 0, i);
        }
    }

    private static void buildMaxHeap(int[] arr, int len) {
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(arr, i, len);
        }
    }
    
//                   6(0)
//              4             3
//        7         5     1        2
//    9      8   12
    private static void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
