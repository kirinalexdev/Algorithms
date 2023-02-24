import java.util.Arrays;

public class MergeSort_repeat {

    public static void main(String[] args) {
        var arr = new int[]{10, 2, -2, 5};
        System.out.println(Arrays.toString(arr));

        var res = sort(arr);
        System.out.println(Arrays.toString(res));
    }

    private static int[] sort(int[] arr) {
        if (arr.length == 1) return arr; // деления массивов закончились
        var middle = arr.length / 2;

        var arr1 = sort(Arrays.copyOfRange(arr, 0, middle));
        var arr2 = sort(Arrays.copyOfRange(arr, middle, arr.length));
        return merge(arr1, arr2);
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        var len = len1 + len2;
        var res = new int[len];
        int a = 0, b = 0; // счетчики массивов

        for (int i = 0; i < len; i++) {

            // еще не выбраны оба массива
            if (a < len1 && b < len2) {
                if (arr1[a] < arr2[b]) {
                    res[i] = arr1[a++];
                } else {
                    res[i] = arr2[b++];
                }
             // стался только arr1
            } else if (a < len1) {
                res[i] = arr1[a++];
            // стался только arr2
            } else  {
                res[i] = arr2[b++];
            }
        }

        return res;
    }

}
