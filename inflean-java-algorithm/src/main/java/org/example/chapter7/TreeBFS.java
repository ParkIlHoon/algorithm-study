package org.example.chapter7;


import java.util.LinkedList;
import java.util.Queue;

public class TreeBFS {

    Node root;
    public static void main(String[] args) {
        TreeBFS tree = new TreeBFS();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        System.out.println(tree.bfs(tree.root));
    }

    public int bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Node poll = queue.poll();
                if (poll.lt == null && poll.rt == null) {
                    return level;
                }

                if (poll.lt != null) {
                    queue.offer(poll.lt);
                }
                if (poll.rt != null) {
                    queue.offer(poll.rt);
                }
            }

            level++;
        }

        return -1;
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
