package binaryTree.linedk;


import java.util.Scanner;

/**
 * 二叉排序树
 */
public class MyTree {
    private int data;  //树上的数据
    private MyTree left;  //左边
    private MyTree right;  //右边

    public MyTree(int data) {
        this.data = data;
    }

    /**
     * 新增的树节点
     * 小于的添加左边  大于的添加左边
     */
    private void add(MyTree myTree) {
        if (myTree.data < this.data) {
            if (left == null) { //务必判断 否则数据会覆盖
                left = myTree;
            } else {
                left.add(myTree);
            }
        } else {
            if (right == null) { //务必判断 否则数据会覆盖
                right = myTree;
            } else {
                right.add(myTree);
            }
        }
    }


    /**
     * 显示树上所有的数据
     */
    private void show() {
        if (left != null) left.show();
        System.out.println(data); //中序
        if (right != null) right.show();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i = 0;

        //创建一个树的根节点
        MyTree tree = new MyTree(50);
        tree.add(new MyTree(45));
        tree.add(new MyTree(49));
        tree.add(new MyTree(82));
        tree.add(new MyTree(75));
        tree.add(new MyTree(46));
        tree.add(new MyTree(99));
        do {
            i = input.nextInt();
            tree.add(new MyTree(i));
        } while (i >0);
        tree.show();
    }


}
