package binarySearchTree;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    // 이진 탐색 트리에 노드 삽입
    void insert(int key) {
        root = insertRec(root, key);
    }

    // 재귀적으로 노드 삽입
    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    // 중위 순회
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        int[] arr = {5, 4, 7, 2, 11};
        for (int value : arr) {
            tree.insert(value);
        }

        tree.inorderRec(tree.root);
    }
}
