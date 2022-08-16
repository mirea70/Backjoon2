package AS.w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class room_number {
    public static void main(String[] args) throws IOException {
        // 입력값을 문자 단위로 나눠 list 리스트에 담는다
        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = bw.readLine().split("");
        // list를 순회하며 세트 수 증가를 판단한다.
        // 세트 수 set_Cnt과 방번호 ing인 StringBuilder 정의
        int Crr_set = 1;
        int temp_set = 0;
        StringBuilder sb = new StringBuilder();
        // 순회 시작
        for(String num : arr){
            // 순회마다 방번호 ing를 채운다.
            sb.append(num);
            // 해당 숫자를 cnt_Set메서드에 넣어, 현재까지 나온 횟수를 센다.
            temp_set = cnt_Set(sb, num);
            // Crr_set < temp_set 이면 Crr_set = temp_set
            if(Crr_set < temp_set) Crr_set = temp_set;
        }
        System.out.println(Crr_set);
    }
    // 숫자와 방번호 ing가 들어오면, 그숫자가 방번호 ing에 지금까지 몇번 들어왔는지 세어 반환한다.
    private static int cnt_Set(StringBuilder sb, String num) {
        int temp_Cnt = 0;
        int six_nine_Cnt = 0;
        for(String v : sb.toString().split("")){
            // 6/9가 아닐때
            if((!num.equals("6"))  && (!num.equals("9"))) {
                // num과 v가 같으면 temp_Cnt 증가
                if(num.equals(v)) temp_Cnt++;
            } else {
                // 6/9일 때
                if(v.equals("6") || v.equals("9")) {
                    six_nine_Cnt++;
                    if(six_nine_Cnt % 2 != 0) {
                        temp_Cnt++;
                    }
                }

            }
        }
        return temp_Cnt;
    }
}
