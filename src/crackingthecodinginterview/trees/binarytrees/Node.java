package crackingthecodinginterview.trees.binarytrees;

public class Node {
    Node left;
    Node right;
    int data;

    public Node(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (value < data) {
            if (left == null) {
                left = new Node(value);
            }
            else left.insert(value);
        }
        else if (value > data) {
            if (right == null) {
                right = new Node(value);
            } else {
                right.insert(value);
            }
        }
    }

    public boolean contains(int value) {
        if (value == data) {
            return true;
        }
        if (value < data) {
            if (left == null) {
                return false;
            }
            else {
                return left.contains(value);
            }
        }
        else {
            if (right == null) {
                return false;
            }
            else {
                return right.contains(value);
            }
        }
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getData() {
        return data;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }

        System.out.println(data);

        if (right != null) {
            printInOrder();
        }
    }

    public void printPreOrder() {
        System.out.println(data);

        if (left != null) {
            left.printInOrder();
        }

        if (right != null) {
            printInOrder();
        }
    }

    public void printPostOrder() {
        if (left != null) {
            left.printInOrder();
        }

        if (right != null) {
            printInOrder();
        }

        System.out.println(data);
    }
}