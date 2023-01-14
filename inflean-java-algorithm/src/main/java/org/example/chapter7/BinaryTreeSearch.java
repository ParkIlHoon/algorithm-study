package org.example.chapter7;

public class BinaryTreeSearch {

    Node root;
    public static void main(String[] args) {
        BinaryTreeSearch tree = new BinaryTreeSearch();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.dfs(tree.root);
    }

    public void dfs(Node root) {
        if (root == null) return;

        dfs(root.lt);
        System.out.println(root.data);
        dfs(root.rt);

    }
    private static class Node {
        int data;
        Node lt;
        Node rt;

        public Node(int data) {
            this.data = data;
            lt = rt = null;
        }
    }
}
