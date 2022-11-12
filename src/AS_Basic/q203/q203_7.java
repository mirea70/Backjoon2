package AS_Basic.q203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q203_7 {
    public static void main(String[] args) throws IOException {
        // 문자열 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str_arr = br.readLine().toCharArray();

        for (int i = 0; i < str_arr.length; i++) {
            // 대문자일 경우
            if(str_arr[i] >= 'A' && str_arr[i] <= 'Z') {
                int code = str_arr[i] + 13;
                if(code > 'Z') code = 'A' + (code - 'Z' - 1);

                str_arr[i] = (char) code;
            }
            // 소문자일 경우
            if(str_arr[i] >= 'a' && str_arr[i] <= 'z') {
                int code = str_arr[i] + 13;
                if(code > 'z') code = 'a' + (code - 'z' - 1);

                str_arr[i] = (char) code;
            }
            // 둘다 아닐 경우
        }
        // 바뀐 문자열 출력
        for(char c : str_arr) System.out.print(c);
    }
}
