
// https://ru.wikibooks.org/wiki/%D0%A0%D0%B5%D0%B0%D0%BB%D0%B8%D0%B7%D0%B0%D1%86%D0%B8%D0%B8_%D0%B0%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC%D0%BE%D0%B2/%D0%A1%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0/%D0%A1%D0%BB%D0%B8%D1%8F%D0%BD%D0%B8%D0%B5%D0%BC#Java_(%D0%A0%D0%B5%D0%BA%D1%83%D1%80%D1%81%D0%B8%D0%B2%D0%BD%D0%B0%D1%8F_%D0%B8_%D0%BD%D0%B5%D1%80%D0%B5%D0%BA%D1%83%D1%80%D1%81%D0%B8%D0%B2%D0%BD%D0%B0%D1%8F_%D1%80%D0%B5%D0%B0%D0%BB%D0%B8%D0%B7%D0%B0%D1%86%D0%B8%D0%B8)

import java.util.Arrays;

public class MergeSort {

    private static int[] sort(int[] arr) {
        int len = arr.length;
        if (len < 2) return arr; // закончили деления массива
        int middle = len / 2;

        var arr1 = sort( Arrays.copyOfRange(arr, 0, middle) );
        var arr2 = sort( Arrays.copyOfRange(arr, middle, len) );
        return merge(arr1, arr2);
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        
        int a = 0, b = 0; // счетчики в массивах
        int len = len1 + len2; 
        
        var res = new int[len]; // в массиве элементам будут устанавливаться значения

        for (int i = 0; i < len; i++) { // i - индекс элементов массива res

            // не дошли до конца в обоих массивах
            if (b < len2 && a < len1) {
                if (arr1[a] > arr2[b]) 
                    res[i] = arr2[b++];
                else
                    res[i] = arr1[a++];
            // остапся только len2
            } else if (b < len2) {
                res[i] = arr2[b++];
            // остапся только len2
            } else {
                res[i] = arr1[a++];
            }
        }
        return res;
    }



    public static void main(String[] args) {
        var arr = new int[]{2, -4, 1, 10, -70, 0, 5};
        System.out.println(Arrays.toString(arr));

        var res = sort(arr);
        System.out.println(Arrays.toString(res));
    }
}
