package org.example.chapter6;

import java.util.Arrays;
import java.util.Scanner;

class Point implements Comparable<Point> {

    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if (this.x == o.x) return this.y - o.y;
        return this.x - o.x;
    }
}

public class PositionSort2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();
        Point[] points = new Point[cnt];
        for (int i = 0; i < cnt; i++) {
            points[i] = new Point(sc.nextInt(), sc.nextInt());
        }

        System.out.println(solution(points));
    }

    private static String solution(Point[] points) {
        Arrays.sort(points);

        StringBuilder sb = new StringBuilder();
        for (Point p : points) {
            sb.append(p.x).append(" ").append(p.y).append("\n");
        }
        return sb.toString();
    }
}
