package AS_Basic;

import java.io.*;

public class q200_5 {
    public static void main(String[] args) throws IOException {
        // 입출력 전처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 현재 문자를 cur_str에 담는다
        String str = br.readLine();
        StringBuilder cur_str = new StringBuilder(str);
        // 커서의 현재 위치 인덱스 location 맨앞이면 -1
        int location = str.length();
        // 입력 반복문 시작
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String temp = br.readLine();
            String[] arr = temp.split(" ");
            // L이면 위치 인덱스를 -1
            if(arr[0].equals("L") && location != 0) {
                location--;
            }
            // D이면 위치 인덱스를 +1
            else if(arr[0].equals("D") && location != cur_str.length()) {
                location++;
            }
            // B이면 현재 위치 문자를 삭제, 현재 위치를 -1
            else if(arr[0].equals("B") && location != 0) {
                cur_str.deleteCharAt(location - 1);
                location--;
            }
            // P이면 공백 다음 문자를 삽입, 현재 위치를 +1
            else if(arr[0].equals("P")){
                cur_str.insert(location, arr[1]);
                location++;
            }
        }
        // 입력 반복문 끝
        br.close();
        // cur_str을 출력
//        bw.write(cur_str.toString());
        System.out.println(cur_str.toString());
        bw.close();
    }
}
