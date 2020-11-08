package stepbystep.step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AB
{
    public static void main(String[] args) throws IOException {
        // version 1
        /*
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(a + b);
         */

        // 아래 코드가 version 1 보다 소요시간이 절반이다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a, b;
        String[] split = br.readLine().split(" ");

        a = Integer.parseInt(split[0]);
        b = Integer.parseInt(split[1]);

        System.out.println(a + b);
    }
}
