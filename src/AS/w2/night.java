package AS.w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class night {
    public static void main(String[] args) throws IOException {
        int cnt = 0;
        // 전처리
        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bw.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        // N ==1 그대로 출력
        if(N == 1) cnt = 1;
        // N == 2  2번 3번 반복 / 방문 칸개수 5개 이상일 시, 방문 칸개수 == 4
        if(N == 2) {
            cnt = Math.min(1 + (M - 1) / 2, 4);
        }
        // N >= 3 1번 4번 반복 / 방문 칸개수 5개 이상일 시, 직전행동을 2번 빼고, 또다시 직전 행동이 1번 이었으면 3번 넣고 칸개수 체크
        if(N >= 3) {
            // M < 7이면 1, 4 만 반복 즉 M번만큼 이동가능, max 방문 = 4
            if(M < 7) {
                cnt = Math.min(M, 4);
            }
            else {
            // M >= 7이면 x가 1씩 증가하는 1,4 만 반복하다가, 4번 빼고 2번 더하므로
                cnt = M - 2;
            }
        }
        System.out.println(cnt);
    }
}
