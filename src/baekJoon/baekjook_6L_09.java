package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjook_6L_09 {
    public static void main(String[] args) throws IOException {
        // 입력값 받기
        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = bw.readLine().split("");
        // 입력 str 순회
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            cnt++;
            // =일 경우
            if(arr[i].equals("=")) {
                // ㄴ 직전이 z, 직직전이 d일결우
                if (i >= 2 && arr[i - 1].equals("z") && arr[i - 2].equals("d")) cnt -= 2;

                else if(i > 0 && arr[i-1].matches("[csz]")) cnt--;

            // -일 경우
            } else if (arr[i].equals("-")) {
                if(i > 0 &&  arr[i-1].matches("[cd]")) cnt--;

            // = and - 둘다 아닐경우
            } else {
                // ㄴ j 일경우
                if(i > 0 &&  arr[i].equals("j") && arr[i-1].matches("l|n")) {
                    cnt--;
                }
            }
        }
        System.out.println(cnt);
    }
}
