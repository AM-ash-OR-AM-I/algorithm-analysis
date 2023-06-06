package tree;

public class BinaryTreeMain {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    int index = -1;

    Node designTree(int[] arr) {
        index++;
        if (arr[index] == -1) {
            return null;
        }
        Node tempNode = new Node(arr[index]);
        tempNode.left = designTree(arr);
        tempNode.right = designTree(arr);
        return tempNode;
    }

    void preOrder(Node root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    void inOrder(Node root) {
        if (root == null) {
            return;
        } else {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        BinaryTreeMain tree = new BinaryTreeMain();
        int[] arr = { 5, 4, 3, 2, -1, -1, 1, -1, -1, -1, -1 };
        Node root = null;
        root = tree.designTree(arr);
        // System.out.println(root.data);
        tree.preOrder(root);
        // tree.inOrder(root);
    }
}

// public class BinaryTreeMain {
// }
