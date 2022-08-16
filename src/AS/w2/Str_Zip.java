package AS.w2;

import java.util.ArrayList;

public class Str_Zip {
    public static void main(String[] args) {
        Str_Zip_Solution obj = new Str_Zip_Solution();
    }
}

class Str_Zip_Solution {
    public int solution(String s) {
        // 전처리
        String[] alpha = s.split("");
        ArrayList<StringBuilder> list = new ArrayList<>();
        StringBuilder benchmark = new StringBuilder();
        StringBuilder compared = new StringBuilder();
        StringBuilder arr = new StringBuilder();
        int cnt = 0;
        int answer = 0;
        // 문자열 s를 순회하며, 문자열 1개단위부터 압축하여 StringBuilder에 넣고 리스트에 담는다.
        // 문자열을 압축하는 자르는 단위는 길이의 절반이 최대이다.
        // 단위 N으로 문자열 자르기 : 인덱스 N-1까지 모두 넣는다. 다음 인덱스부터 해당인덱스 + N-1인덱스 까지 넣는다.
        for (int N = 1; N <= alpha.length / 2; N++) {
            for (int i = 0; i < alpha.length; i++) {
                // 첨에 alpha에 N개 넣기
                if(i < N) benchmark.append(alpha[i]);
                // 그담부턴 coppared에 N개 넣기
                compared.append(alpha[i]);
                // 비교한다.
                if(!benchmark.equals(compared)) arr.append(benchmark);
                else {
                    cnt++;
                }
            }
        }


        // 두 str이 같으면 cnt++, 문자열 s 마지막까지 이를 반복한다.
        // 리스트의 요소를 요소의 길이순으로 오름차순 정렬렬한다.
       // 리스트의 0번 인덱스의 길이를 리턴한다.
        return answer;
    }
}