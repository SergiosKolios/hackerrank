package crackingthecodinginterview.trees.binarytrees;

public class Solution {

    public static void main(String[] args) {
        Node correctTree = generateCorrectBalancedTree(4);
        Node inCorrectTree = generateIncorrectTree01(3);
        BSTUtil bstUtil = new BSTUtil();
        boolean isValid = bstUtil.checkBST(inCorrectTree);

        System.out.println("Tree is valid: " + isValid);
        System.out.println(correctTree);

    }


    private static Node generateCorrectBalancedTree(int value) {
        Node root = new Node(value);
        root.insert(2);
        root.insert(6);
        root.insert(1);
        root.insert(3);
        root.insert(5);
        root.insert(7);

        return root;
    }

    private static Node generateIncorrectTree01(int value) {
        Node root = new Node(value);
        root.setLeft(new Node(2));
        root.getLeft().setLeft(new Node(1));
        root.setRight(new Node(4));
        root.getRight().setLeft(new Node(5));
        root.getRight().setRight(new Node(6));

        return root;
    }
}
