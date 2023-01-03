package org.example.chapter2;

import java.util.Scanner;

/**
 * <h1>3. 가위 바위 보</h1>
 * A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
 * 가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
 *
 * <ul>
 *     <li>입력 :
 *          <pre>{@code 5}</pre>
 *          <pre>{@code 2 3 3 1 3}</pre>
 *          <pre>{@code 1 1 2 2 3}</pre>
 *     </li>
 *
 *     <li>출력 :
 *          <pre>{@code A}</pre>
 *          <pre>{@code B}</pre>
 *          <pre>{@code A}</pre>
 *          <pre>{@code B}</pre>
 *          <pre>{@code D}</pre>
 *     </li>
 * </ul>
 */
public class RockPaperScissor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        String a = sc.nextLine();
        String b = sc.nextLine();
        solution(count, a, b);
    }

    private static void solution(int count, String a, String b) {
        String[] aArr = a.split("\\s");
        String[] bArr = b.split("\\s");

        for (int i = 0; i < count; i++) {
            int aa = Integer.parseInt(aArr[i]);
            int bb = Integer.parseInt(bArr[i]);

            switch (aa - bb) {
                case -2, 1 -> System.out.println("A");
                case -1, 2 -> System.out.println("B");
                default -> System.out.println("D");
            }
        }
    }

}
