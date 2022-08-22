package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_6L_10 {
    public static void main(String[] args) throws IOException {
        // 입력받고 아래 행위를 첫째줄만큼 반복한다.
        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bw.readLine());
        // 그룹단어 체킹할 임시 boolean, 그룹단어 개수 int 생성
        boolean temp = false;
        int group_Cnt = 0;

        for (int i = 0; i < N; i++) {
            // group_chk에 단어를 넣어 true이면 group_Cnt++
            temp = group_chk(bw.readLine());
            if(temp == true) group_Cnt++;
        }
        // 반복 종료 후, group_Cnt++ 출력
        System.out.println(group_Cnt);
    }
    private static boolean group_chk(String str) {
        // 한번 나온 문자는 연속된 후에 다시나오면 안된다.
        String tm = "";
        tm += str.substring(0, 1);
        // 들어온 문자열 길이만큼의, 체크할 cnt[] 생성
        int[] cnt = new int[str.length()];
        // 들어온 문자열 길이만큼의, 체크할 chk[] 생성
        boolean chk[] =  new boolean[str.length()];
        chk[0] = true;
        // 문자열을 순회하며, 한번 나온 문자는 chk = true, cnt++한다.
        for (int i = 1; i < str.length(); i++) {
            String subStr = str.substring(i, i+1);

//            System.out.println(tm);
//            System.out.println(tm.substring(i, i+1));
            // 만약 해당 문자가 나왔던 문자라면 false로 변환
            if(tm.contains(subStr) && str.charAt(i) != str.charAt(i-1)) {
                chk[i] = false;
                tm += subStr;
            }
            else chk[i] = true;
            tm += subStr;
        }
        // 다른 문자가 나오면 chk =false
        // 문자열 순회가 끝나고, chk[] 를 순회하여, chk가 한번이라도 false가 나오면 false 반환, 아니라면 true 반환
        for(boolean b : chk) {
            if(b == false) return false;
        }
        return true;
    }
}
