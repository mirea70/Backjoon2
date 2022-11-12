package AS_Basic;

import java.util.Arrays;
import java.util.Scanner;

public class q203_9 {
    public static void main(String[] args) {
        // 전처리
        Scanner sc = new Scanner(System.in);
        // 문자열의 길이만큼 문자열을 담을 배열 생성
        String str = sc.nextLine();
        String[] arr = new String[str.length()];
        // 접미사 하나씩 때서 배열에 집어넣기 n
        for (int i = 0; i < arr.length; i++) {
            arr[i] = str.substring(i);
        }
        // 배열을 사전 순으로 정렬 n log n 10^3 log(10 ^ 3)
        Arrays.sort(arr);
        // 배열 출력
        for(String s : arr) System.out.println(s);
    }
}
