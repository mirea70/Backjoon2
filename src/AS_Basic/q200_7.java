package AS_Basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q200_7 {
    public static void main(String[] args) {
        // 입력을 한 라인 받는다.
        // N은 총 사람 수
        // 큐에 1 ~ N 담기
        // 큐 사이즈가 1일때까지 반복
        // k - 1 번째까지 맨뒤로 보낸다 (이렇게해야 계속 반복문이 이어짐)
        // k번째이면 sb에 append
        // 반복문 끝
        // Sb에 큐 poll해서 추가하고, ">" 추가
        // StringBilder 출력

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        while (q.size() != 1) {
            for (int i = 1; i <= K - 1; i++) {
                q.offer(q.poll());
            }
            sb.append(q.poll()).append(", ");
        }
        sb.append(q.poll()).append(">");

        System.out.print(sb);
    }
}
