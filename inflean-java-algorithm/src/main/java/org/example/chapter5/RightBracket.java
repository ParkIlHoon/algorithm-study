package org.example.chapter5;

import java.util.Scanner;
import java.util.Stack;

/**
 * <h1>1. 올바른 괄호</h1>
 *
 * 괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
 * (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
 *
 * <ul>
 *     <li>입력 :
 *          <pre>{@code (()(()))(()}</pre>
 *     </li>
 *
 *     <li>출력 :
 *          <pre>{@code NO}</pre>
 *     </li>
 * </ul>
 */
public class RightBracket {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(solution(s));
    }

    private static String solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char x : s.toCharArray()) {
            if (x == '(') {
                stack.push(x);
            } else if (x == ')') {
                if (stack.isEmpty()) return "NO";
                stack.pop();
            }
        }

        return stack.isEmpty()? "YES" : "NO";
    }

}
