package src.com.divide;

public class Test2 {

    //1、 i++ 返回原来的值，++i 返回加1后的值。
    //2、 i++ 不能作为左值，而++i 可以。

    //快速排序 分治法
    public static void main(String[] args) {
        int[] a = {6, 4, 3, 7, 5, 1, 2, 9, 8};
        int length = a.length;
        quickSort(a, 0, length - 1);
        for (int i = 0; i < length; i++) {
            System.out.println("------------" + a[i]);
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (high <= low) return;
        int i = low, j = high + 1;
        int key = arr[low];

        System.out.println("------排序前------");
        for (int pi = low; pi <= high; pi++) {
            System.out.println(arr[pi]);
        }

        while (true) {
            /*从左向右找比key大的值*/
            while (arr[++i] < key) {
                if (i == high) {
                    break;
                }
            }
            /*从右向左找比key小的值*/
            while (arr[--j] > key) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) break;;
            /*交换i,j对应的值*/
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        /*中枢值与j对应值交换*/
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        System.out.println("------排序后------");
        for (int pi = low; pi <= high; pi++) {
            System.out.println(arr[pi]);
        }

        quickSort(arr, low, j - 1);
        quickSort(arr, j + 1, high);
    }
}
