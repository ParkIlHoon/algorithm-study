package org.example.chapter6;

import java.util.Arrays;
import java.util.Scanner;

public class Stall {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int stallCnt = sc.nextInt();
        int horseCnt = sc.nextInt();
        int[] stallPoints = new int[stallCnt];
        for (int i = 0; i < stallCnt; i++) {
            stallPoints[i] = sc.nextInt();
        }

        System.out.println(solution(horseCnt, stallPoints));
    }

    private static int solution(int horseCnt, int[] stallPoints) {
        Arrays.sort(stallPoints);

        int lt = 1;
        int rt = stallPoints[stallPoints.length-1];

        int result = 0;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;    // 최대 거리
            int availableHorseCnt = count(mid, stallPoints);

            if (availableHorseCnt >= horseCnt) {
                result = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        return result;
    }

    private static int count(int mid, int[] stallPoints) {
        int result = 1;
        int before = stallPoints[0];
        for (int i = 1; i < stallPoints.length; i++) {
            if (stallPoints[i] - before >= mid) {
                result++;
                before = stallPoints[i];
            }
        }
        return result;
    }


}
