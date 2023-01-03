package org.example.chapter5;


import java.util.Scanner;
import java.util.Stack;

public class RemoveBracket {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(solution(s));
    }

    private static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) continue;
                stack.pop();
            } else {
                if (stack.isEmpty()) {
                    sb.append(s.charAt(i));
                }
            }
        }

        return sb.toString();
    }
}
