package binaryTree.linked;

public class Test01 {

    Node head = new Node();

    /**
     * 增加操作（最后一个增加）
     */
    public void addNiode(Node node) {
        //链表中有结点，遍历到最后一个结点
        Node temp = head;
        ;    //一个移动的指针(把头结点看做一个指向结点的指针)
        while (temp.next != null) {    //遍历单链表，直到遍历到最后一个则跳出循环。
            temp = temp.next;        //往后移一个结点，指向下一个结点。
        }
        temp.next = node;    //temp为最后一个结点或者是头结点，将其next指向新结点
    }


    /**
     * index 那个位置插入
     * node:插入的结点
     */
    public void insertNodeByIndex(int index, Node node) {
        //首先需要判断指定位置是否合法，
        if (index < 1 || index > length() + 1) {
            System.out.println("插入位置不合法。");
            return;
        }
        int length = 1;            //记录我们遍历到第几个结点了，也就是记录位置。
        Node temp = head;        //可移动的指针
        while (head.next != null) {//遍历单链表
            if (index == length++) {        //判断是否到达指定位置。
                node.next = temp.next;
                temp.next = node;
                return;
            }
            temp = temp.next;
        }
    }

    /**
     * 通过index删除指定位置的结点
     */
    public void delNodeByIndex(int index) {
        //判断index是否合理
        if (index < 1 || index > length()) {
            System.out.println("请输入大于1的数字");
            return;
        }
        //步骤跟代参新增是一样的，只是操作不一样。
        int length = 1;
        Node temp = head;
        while (temp.next != null) {
            if (index == length++) {
                //删除操作。
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }

    /**
     * 顺时针排序
     */
    public void selectSortNode() {
        if (length() < 2) {
            System.out.println("不需要排序");
            return;
        }
        //选择排序
        Node temp = head;            //第一层遍历使用的移动指针，最处指向头结点，第一个结点用temp.next表示
        while (temp.next != null) {    //第一层遍历链表，从第一个结点开始遍历
            Node secondTemp = temp.next;        //第二层遍历使用的移动指针，secondTemp指向第一个结点，我们需要用到是第二个结点开始，所以用secondNode.next
            while (secondTemp.next != null) {//第二层遍历,从第二个结点开始遍历
                if (temp.next.data > secondTemp.next.data) {    //第二层中的所有结点依次与第一次遍历中选定的结点进行比较，
                    int t = secondTemp.next.data;
                    secondTemp.next.data = temp.next.data;
                    temp.next.data = t;
                }
                secondTemp = secondTemp.next;
            }
            temp = temp.next;
        }
    }

    /**
     * 逆时针排序
     */
    public void insertSortNode() {
        //判断链表长度大于2，不然只有一个元素，就不用排序了。
        if (length() < 2) {
            System.out.println("不需要排序");
            return;
        }
        //创建新链表
        Node newHead = new Node(0);    //新链表的头结点
        Node newTemp = newHead;        //新链表的移动指针
        Node temp = head;        //旧链表的移动指针
        if (newTemp.next == null) {        //将第一个结点直接放入新链表中。
            Node node = new Node(temp.next.data);
            newTemp.next = node;
            temp = temp.next;    //旧链表中指针移到下一位(第二个结点处)。
        }
        while (temp.next != null) {     //    遍历现有链表
            while (newTemp.next != null) {
                if (newTemp.next.data < temp.next.data) {
                    Node node = new Node(temp.next.data);
                    node.next = newTemp.next;
                    newTemp.next = node;
                    break;
                }
                newTemp = newTemp.next;
            }
            if (newTemp.next == null) {//到达最末尾还没符合，那么说明该值是新链表中最小的数，直接添加即可到链表中即可
                //直接在新链表后面添加
                Node node = new Node(temp.next.data);
                newTemp.next = node;
            }
            //旧链表指针指向下一位结点，继续重复和新链表中的结点进行比较。
            temp = temp.next;
            //新链表中的移动指针需要复位，指向头结点
            newTemp = newHead;
        }
        //开始使用新链表，旧链表等待垃圾回收机制将其收回。
        head = newHead;

    }

    /**
     * 计算有多少结点
     */
    public int length() {
        int length = 0;
        Node temp = head;
        while (temp.next != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 遍历单链表，打印所有data
     */
    public void print() {
        Node temp = head.next;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println();
    }


}
