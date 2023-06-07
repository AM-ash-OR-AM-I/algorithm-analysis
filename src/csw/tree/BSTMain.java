package tree;

import utils.Util;

class BinarySearchTree extends BinaryTree {

    private Node insert(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        } else if (value < root.data) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public void insert(int value) {
        rootNode = insert(rootNode, value);
    }

    public int minValue() {
        Node curNode = rootNode;
        while (curNode.left != null) {
            curNode = curNode.left;
        }
        return curNode.data;
    }

    public int maxValue() {
        Node curNode = rootNode;
        while (curNode.right != null) {
            curNode = curNode.right;
        }
        return curNode.data;
    }

    private Node findNode(Node root, int value) {
        if (root == null) {
            return null;
        }
        if (root.data == value) {
            return root;
        } else if (value < root.data) {
            return findNode(root.left, value);
        } else {
            return findNode(root.right, value);
        }
    }

    public boolean findNode(int value) {
        return findNode(rootNode, value) != null;
    }

    private Node intermediateSuccesor(Node deleteNode) {
        Node deleteNodeRight = deleteNode.right;
        while (deleteNodeRight.left != null) {
            deleteNodeRight = deleteNodeRight.left;
        }
        return deleteNodeRight;
    }

    private Node delete(Node root, int value) {
        Node deleteNode = findNode(root, value);
        if (deleteNode == null) {
            System.out.println("No node found!");
            return null;
        }
        Node succesorNode = intermediateSuccesor(deleteNode);
        System.out.println(deleteNode.data + " " + succesorNode.data);
        // TODO: Delete The node somehow
        // succesorNode.left = deleteNode.left;
        // succesorNode.right = deleteNode.right;
        return succesorNode;
    }

    public void deleteNode(int value) {
        delete(rootNode, value);
    }
}

public class BSTMain {
    public static void main(String[] args) {
        int[] arr = Util.takeUserInput();
        BinarySearchTree bst = new BinarySearchTree();
        for (int i = 0; i < arr.length; i++) {
            bst.insert(arr[i]);
        }
        // Prints in sorted order.
        bst.inOrder();
        System.out.println();
        System.out.println("Max Value = " + bst.maxValue());
        System.out.println("Min Value = " + bst.minValue());
        bst.deleteNode(5);
    }
}