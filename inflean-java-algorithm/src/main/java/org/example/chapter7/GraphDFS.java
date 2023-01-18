package org.example.chapter7;

import java.util.Scanner;

public class GraphDFS {

    static int pointCnt;
    static int answer;
    static int[][] graph;
    static int[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        pointCnt = sc.nextInt();
        int lineCnt = sc.nextInt();
        graph = new int[pointCnt + 1][pointCnt + 1];

        for (int i = 0; i < lineCnt; i++) {
            graph[sc.nextInt()][sc.nextInt()] = 1;
        }

        check = new int[graph.length];
        check[1] = 1;

        solution(1);
    }

    public static void solution(int v) {
        if (v == pointCnt) answer++;
        else {
            for (int i = 1; i <= pointCnt; i++) {
                if (graph[v][i] == 1 && check[i] == 0) {
                    check[i] = 1;
                    solution(i);
                    check[i] = 0;
                }
            }
        }
    }


}
