package gather;

public class id3 {
    public static void main(String[] args) {

        int[][] arr = {{1}, {2, 2}, {3, 3, 3}, {4, 4, 4, 4}, {5, 5, 5, 5, 5}, {6, 6, 6, 6, 6, 6}};
        for (int i = 0; i < arr.length; i++) { //遍历二维数组，遍历出来的每一个元素是一个一维数组
            for (int j = 0; j < arr[i].length; j++) { //遍历对应位置上的一维数组
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        for (int[] i:arr){
            for (int j:i){
                System.out.print(j);
            }
            System.out.println();
        }

        //存放的是电话号码包含的数字
        int[] nums = {4, 2, 1, 0, 8, 3};
        //电话号码出现的下标
        int[] index = {2, 4, 5, 2, 3, 0, 3, 2, 1, 0, 0};
        // 求电话号码15753049998
        for (int i = 0; i < index.length; i++) {
            System.out.print(nums[index[i]]);
        }
        System.out.println();
        for (int a : index) {
            System.out.print(nums[a]);
        }

    }
}
