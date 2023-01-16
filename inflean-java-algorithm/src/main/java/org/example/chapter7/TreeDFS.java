package org.example.chapter7;

public class TreeDFS {

    Node root;
    public static void main(String[] args) {
        TreeDFS tree = new TreeDFS();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
    }

    public int dfs(int level, Node root) {
        if (root.lt == null && root.rt == null) return level;

        return Math.min(dfs(level + 1, root.lt), dfs(level + 1, root.rt));
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
