package knowledge.contend1;

import java.util.Arrays;

public class IndexNum3 {

    public static void main(String[] args) {
        int[] arr = {6, 3, 1, 4, 50, 5};
        int temp = 0;
//        冒泡排序
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(arr[arr.length - 2]);
    }
}
