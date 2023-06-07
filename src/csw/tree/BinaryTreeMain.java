package tree;

class BinaryTree {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    int index = -1;
    Node rootNode;

    private Node designTreeRec(int[] arr) {
        index++;
        if (arr[index] == -1) {
            return null;
        }
        Node tempNode = new Node(arr[index]);
        tempNode.left = designTreeRec(arr);
        tempNode.right = designTreeRec(arr);
        return tempNode;
    }

    void designTree(int[] arr) {
        rootNode = designTreeRec(arr);
    }

    private void preOrder(Node root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    void preOrder() {
        preOrder(rootNode);
        System.out.println();
    }

    private void inOrder(Node root) {
        if (root == null) {
            return;
        } else {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    void inOrder() {
        inOrder(rootNode);
        System.out.println();
    }

    private void postOrder(Node root) {
        if (root == null) {
            return;
        } else {
            inOrder(root.left);
            inOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    void postOrder() {
        postOrder(rootNode);
        System.out.println();
    }
}

public class BinaryTreeMain {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] arr = { 5, 4, 3, 2, -1, -1, 1, -1, -1, -1, -1 };
        tree.designTree(arr);
        tree.inOrder();
    }
}
