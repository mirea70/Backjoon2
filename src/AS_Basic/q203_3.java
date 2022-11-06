package AS_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q203_3 {
    public static void main(String[] args) throws IOException {
        // 알파벳 소문자 아스키코드 97 ~ 122번
        // count 배열 생성 26 크기
        int[] count = new int[26];
        // 단어 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        // 단어 순회
        for (char ch : str) {
            // 문자를 아스키로 변환한 뒤 - 97 후, 인덱스와 비교
            // 같으면 그 인덱스 ++
            count[(int)ch - 97]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i : count) {
            sb.append(i).append(' ');
        }
        System.out.print(sb);
    }
}
