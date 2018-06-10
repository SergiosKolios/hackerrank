package crackingthecodinginterview.trees.binarytrees;

import com.sun.istack.internal.NotNull;

public class BSTUtil {

    public boolean checkBST(@NotNull Node root) {
        return checkNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean checkNode(Node node, int minValue, int maxValue) {
        if (node == null) {
            return true;
        }
        if (node.getData() < minValue || node.getData() > maxValue) {
            return false;
        }
        return checkNode(node.getLeft(), minValue, node.getData() -1) && checkNode(node, node.getData() + 1, maxValue);
    }
//    // Wrong solution - first try, common mistake
//    private boolean checkNode(Node node) {
//        boolean result = true;
//        int value = node.getData();
//        if (node.getLeft() != null) {
//            if (value < node.getLeft().getData()) {
//                return false;
//            }
//            result = result && checkNode(node.getLeft());
//        }
//        if (node.getRight() != null) {
//            if (value > node.getRight().getData()) {
//                return false;
//            }
//            result = result && checkNode(node.getRight());
//        }
//        return result;
//    }
}
