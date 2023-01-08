package org.example.chapter6;

import java.util.Arrays;
import java.util.Scanner;

public class MusicVideo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int songCnt = sc.nextInt();
        int dvdCnt = sc.nextInt();
        int[] songs = new int[songCnt];
        for (int i = 0; i < songCnt; i++) {
            songs[i] = sc.nextInt();
        }

        System.out.println(solution(songs, dvdCnt));
    }

    private static int solution(int[] songs, int dvdCnt) {
        int result = -1;

        int lt = Arrays.stream(songs).max().getAsInt();
        int rt = Arrays.stream(songs).sum();

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int required = count(songs, mid);
            if (required <= dvdCnt) {
                result = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return result;
    }

    private static int count(int[] songs, int capacity) {
        int cnt = 1;
        int sum = 0;

        for (int x : songs) {
            if (sum + x > capacity) {
                cnt++;
                sum = x;
            } else {
                sum += x;
            }
        }

        return cnt;
    }

}
