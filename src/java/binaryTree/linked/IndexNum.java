package binaryTree.linked;

import java.util.ArrayList;
import java.util.List;

public class IndexNum {
    public static void main(String[] args) {


        Node node = new Node();

        Test01 te = new Test01();
        te.addNiode(new Node(20)); //给链表添加数据
        te.addNiode(new Node(10));
        te.addNiode(new Node(150));
        te.addNiode(new Node(2));
        te.insertNodeByIndex(2, new Node(50)); // 给链表按位置添加数据
        te.delNodeByIndex(1); //   按位置删除链表
        te.print();

        te.selectSortNode();//  正向排序链表
        te.print();


        te.insertSortNode();// 反向排序链表
        te.print();


    }

}
