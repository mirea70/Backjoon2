package AS_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q203_5 {
    public static void main(String[] args) throws IOException {
        // 입출력 받기 (입력 값이 null이 아닐때까지 반복)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";


        while ((input = br.readLine()) != null) {
            // 아스키코드 범위 비교 조건문으로 각 경우에 count[]을 만들어 센다.
            StringBuilder sb = new StringBuilder();

            int[] count = new int[4];

            char[] str_ch = input.toCharArray();
            for(char c : str_ch) {
                if(c >= 'a' && c <= 'z') count[0] ++;
                else if(c >= 'A' && c <= 'Z') count[1] ++;

                else if(c >= '0' && c <= '9') count[2] ++;

                else if(c == ' ') count[3] ++;
            }
            // count 출력
            for(int i : count) sb.append(i).append(' ');
            System.out.println(sb);
//            sb.setLength(0);
        }
//        br.close();
    }
}
