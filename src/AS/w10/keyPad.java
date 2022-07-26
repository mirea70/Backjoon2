package AS.w10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class keyPad {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand = "right";
        keyPad_Solution k = new keyPad_Solution();
        System.out.println(k.solution(numbers, hand));
    }
}
class keyPad_Solution {
    ArrayList[] list = new ArrayList[3];
    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < 3; i++) {
            list[i] = new ArrayList();
            for (int j = i+1; j < 10; j+=3) {
                list[i].add(j);
            }
        }
        list[0].add("*");
        list[1].add(0);
        list[2].add("#");

        System.out.println(list[2].toString());

        // 현재 위치 저장할 왼손 오른손 int 공간 생성
        int left = -1;
        int right = -1;
        // nubers 순회
        for(int v : numbers){
            // 1,4,7이면 왼손을 스트링빌더에 넣는다, 그리고, 그 숫자를 왼손 위치에 저장
            if(v == 1||v == 4||v == 7) {
                sb.append("L");
                left = v;
            // 3,6,9이면 오른손을 스트링빌더에 넣는다, 그리고, 그 숫자를 오른손 위치에 저장
            }else if(v == 3||v == 6||v == 9){
                sb.append("R");
                right = v;
            // 2,5,8,0일때, 왼손의 차이와 오른손의 차이를 비교한다. 차이가 작은 쪽의 손을 스트링빌더에 넣는다. 그리고, 그 숫자를 작은쪽 위치에 저장
            } else {
                if(minus(left,right,v) < 0) {
                    sb.append("L");
                    left = v;
                } else if (minus(left,right,v) > 0) {
                    sb.append("R");
                    right = v;
            // 차이가 같다면, hand를 대문자변환한 첫 문자를 넣고, 그 숫자를 L이면 왼손 공간, R이면 오른손 공간에 넣는다.
                } else {
                    char ch = hand.toUpperCase().charAt(0);
                    sb.append(ch);
                    if(ch == 'L') left = v;
                    else if(ch == 'R') right = v;
                }
            }
        }
        // 순회 끝
        answer = sb.toString();
        // 리턴
        return answer;
    }
    public int minus(int left, int right, int value) {
        Map<Integer, Integer> left_index = new HashMap<>();
        Map<Integer, Integer> right_index = new HashMap<>();
        Map<Integer, Integer> value_index = new HashMap<>();
        int leftkey = 0;
        int rightkey = 0;
        // 왼손과 오른손 위치 찾기
        if(list[0].contains(left)) {
            left_index.put(0, list[0].indexOf(left));
        }
        if(list[1].contains(left)){
            left_index.put(1, list[1].indexOf(left));
            leftkey = 1;
        }
        if(list[2].contains(right)) {
            right_index.put(2, list[2].indexOf(right));
            rightkey = 2;
        }
        if(list[1].contains(right)) {
            right_index.put(1, list[1].indexOf(right));
            rightkey = 1;
        }

        if(left == -1){
            leftkey = 0;
            left_index.put(0, 3);
        }
        if(right == -1) {
            rightkey = 2;
            right_index.put(2, 3);
        }

        // 들어온 값 위치 찾기
        value_index.put(1, list[1].indexOf(value));
        // 인덱스 간 차이 2차원으로 더하여 리턴
        int answer = (Math.abs(leftkey - 1) + Math.abs(left_index.get(leftkey) - value_index.get(1))) -
                (Math.abs(rightkey - 1) + Math.abs(right_index.get(rightkey) - value_index.get(1)));

        return answer;
    }
}
