package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class baekjoon_6L_05 {
    public static void main(String[] args) throws IOException {
        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
        String str = bw.readLine();
        bw.close();
        // 대문자로 모두 바꾼다.
        str = str.toUpperCase();
        // map을 만들고, 단어를 순회하여,
        Map<Character, Integer> map = new HashMap<>();
        // 문자를 가지고있지 않으면 put, 1
        for (int i = 0; i < str.length(); i++) {
            if(!map.containsKey(str.charAt(i))){
                map.put(str.charAt(i), 1);
        // 가지고 있으면 해당문자를 가지고있는 키의 값을 ++
            }else {
                map.put(str.charAt(i), map.get(str.charAt(i))+ 1);
            }
        }
        // 순회 끝
        // 맵을 순회하며 값중 최댓값 구하기
        int max = map.values().stream().mapToInt(i -> i).max().getAsInt();
        // 맵을 다시 순회하며, 값 중 최대값과 같은 값 2개 이상이 있으면 ? 출력 break
        int cnt = 0;
        for (Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue() == max) cnt++;
        }
        if(cnt >= 2) {
            System.out.println("?");
        } else {
            for (Map.Entry<Character, Integer> entry : map.entrySet()){
                if(entry.getValue() == max) {
                    System.out.println(entry.getKey());
                    break;
                }
            }
        }
    }
}
