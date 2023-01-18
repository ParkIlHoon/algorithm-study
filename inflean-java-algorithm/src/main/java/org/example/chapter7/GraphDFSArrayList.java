package org.example.chapter7;

import java.util.ArrayList;
import java.util.Scanner;

public class GraphDFSArrayList {

    static int pointCnt;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] check;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        pointCnt = sc.nextInt();
        int lineCnt = sc.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= pointCnt; i++) {
            graph.add(new ArrayList<Integer>());
        }
        check = new int[pointCnt + 1];

        for (int i = 0; i < lineCnt; i++) {
            graph.get(sc.nextInt()).add(sc.nextInt());
        }
        check[1] = 1;
        dfs(1);
    }

    public static void dfs(int v) {
        if (v == pointCnt) answer++;
        else {
            for (int nv : graph.get(v)) {
                if (check[nv] == 0) {
                    check[nv] = 1;
                    dfs(nv);
                    check[nv] = 0;
                }
            }
        }
    }

}
