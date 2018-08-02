package binaryTree;




public class binaryTree {


    public static void main(String[] args) {
        BinTree binTree = new BinTree();
        Object[] objs = {0, 1, 2, 3, 4, 5, 6, 7};
        binTree.createTree(objs);
        binTree.preorder(binTree.getRoot()); //先序遍历
        System.out.println();
        binTree.inorder(binTree.getRoot()); //中序遍历
        System.out.println();
        binTree.afterorder(binTree.getRoot()); //后序遍历
    }

}
