package AS.w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class night_implement {
    public static void main(String[] args) throws IOException {
        int cnt = 1;
        // 전처리
        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bw.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        // y : 현재 세로 위치, x : 현재 가로 위치, stack : 방문한 이동법 번호 누적, cnt : 방문 칸개수 카운트
        int y = 1;
        int x = 1;
        Stack stack = new Stack();
        // N ==1 그대로 출력
        if(N == 1) System.out.print(cnt);
        // N == 2  2번 3번 반복 / 방문 칸개수 5개 이상일 시, 방문 칸개수 == 4
        if(N == 2) {
            while (x <= M -2) {
                x += 2;
                y += 1;
                stack.push(2);
                cnt++;

                if(x >= M - 1) break;
                x += 2;
                y -= 1;
                stack.push(3);
                cnt++;
                if(stack.size() > 4) stack.remove(0);
            }
            if(cnt >= 5) cnt = 4;
            System.out.println(cnt);
        }
        // N >= 3 1번 4번 반복 / 방문 칸개수 5개 이상일 시, 직전행동을 2번 빼고, 또다시 직전 행동이 1번 이었으면 3번 넣고 칸개수 체크
        if(N >= 3) {
            while (x <= M) {
                x += 1;
                y += 2;
                stack.push(1);
                cnt++;

                if(x >= M) break;
                x += 1;
                y -= 2;
                stack.push(4);
                cnt++;

                if(stack.size() > 4) stack.remove(0);
            }
            // 칸개수가 5개 미만이면 그대로 출력
            if(cnt < 5) System.out.println(cnt);

            if(cnt == 5) {
                cnt = 4;
                System.out.println(cnt);
            }
            // 여전히 칸개수가 5개 이상이면, 직전 행동을 3번 빼고, 또다시 직전 행동이 1번 이었으면 3번 넣고 , 2번 넣고 출력 / 4번이었음 2번, 3번 넣음
            if(cnt >= 6) {
                stack.pop();
                stack.pop();
                stack.pop();
                stack.pop();
                cnt = cnt -4;

                if((int)stack.peek() == 1) {
                    x += 2;
                    y -= 1;
                    stack.push(3);
                    cnt++;

                    x += 2;
                    y += 1;
                    stack.push(2);
                    cnt++;

                } else {
                    x += 2;
                    y += 1;
                    stack.push(2);
                    cnt++;

                    x += 2;
                    y -= 1;
                    stack.push(3);
                    cnt++;
                }
                System.out.println(cnt);
            }
        }
    }
}
