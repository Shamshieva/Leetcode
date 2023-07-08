public class BinaryTree {
    Node root;

    Boolean isBalanced(Node node){
        int leftHeight;
        int rightHeight;

        if (node == null) return true;

        leftHeight = height(node.left);
        rightHeight = height(node.right);

        return Math.abs(leftHeight - rightHeight) == 1
                && isBalanced(node.left) && isBalanced(node.right);
    }

    int height(Node node){
        if (node == null){
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
