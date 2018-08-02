package binaryTree.linedk;

public class MyNode {
    private int data;  //元素adb的值
    private MyNode next; //下一个元素

    public MyNode(int data) {
        this.data = data;   //把用户传来的值 给我们结点 的元素
    }

    private void append(MyNode myNode) {
        MyNode node = this;
        while (node.next != null) {
            node = node.next;
        }
        node.next = myNode;
    }

    private void add(MyNode myNode) {
        myNode.next = next;
        next = myNode;
    }


    public void shou() {
        MyNode node = this;
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }

    }


    public static void main(String[] args) {
        MyNode node = new MyNode(100);
        node.append(new MyNode(120));
        node.append(new MyNode(130));
        node.append(new MyNode(110));
        node.add(new MyNode(10));
        node.add(new MyNode(124));
        node.shou();
    }


}
