package AS.w10;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class rightBefore {
    public static void main(String[] args) {
        String m = "ABC";
        String[] musicinfos = new String[]{
                "00:00,00:04,HI,ABC#ABC"
        };

        rightBefore_Solution s = new rightBefore_Solution();

        String answer = s.solution(m, musicinfos);
        System.out.println(answer);
    }
}

class rightBefore_Solution {
    public String solution(String m, String[] musicinfos) {
        // 조건 일치하는 제목, 재생시간이 담긴 배열을 담을 리스트 생성
        ArrayList<String[]> list = new ArrayList<>();
        String[] temp;
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        DateFormat format = new SimpleDateFormat("HH:mm");
        String answer = "";
        // musicinfos 순회
        for(String music : musicinfos) {
            // 요소를 , 기준으로 배열 생성
            temp = music.split(",");
            // 생성된 배열의 마지막 인덱스의 글자들이 인자 m의 있는 요소의 순서대로 존재하는지 체크
            // m의 첫인덱스와 동일한 문자가 있는 인덱스를 찾는다.
            for (int i = 0; i < temp[temp.length-1].length(); i++) {
                if(m.charAt(0) == temp[temp.length-1].charAt(i)) {
                    idx = i;
                    break;
                }
            }
            // 그 인덱스부터 m의 길이만큼 순회한다. (순회중, 단어길이 도달 시, 첫인덱스로 이동해 순회)
            for (int i = 0; i <= m.length(); i++) {
                if(idx == temp[temp.length-1].length()) idx = 0;
            // 순회하며 새로운 String를 만들어 넣는다.
                sb.append(temp[temp.length-1].charAt(idx));
                idx++;
            }
            if(sb.charAt(sb.length() -1) == '#') {
                sb.setLength(0);
                continue;
            } else {
                sb.setLength(sb.length() -1);
                // m과 비교하여 같을 시, temp를 리스트에 추가
                String new_str = sb.toString();
                if(new_str.equals(m)) list.add(temp);
                sb.setLength(0);
            }
        }
        // 순회 끝
        // 리스트 사이즈 > 1 일 경우, 리스트의 각 요소(배열)의 2번째 인덱스(재생시간)이 가장 긴 요소의 1번째 인덱스(제목)을 반환
        if(list.size() > 1) {
            Collections.sort(list, new Comparator<String[]>() {
                @Override
                public int compare(String[] o1, String[] o2) {

                    try {
                        if((format.parse((o1[1])).getTime()  - format.parse((o1[0])).getTime())
                                > (format.parse((o2[1])).getTime()  - format.parse((o2[0])).getTime()))
                            return -1;
                        else if ((format.parse((o1[1])).getTime()  - format.parse((o1[0])).getTime())
                                < (format.parse((o2[1])).getTime()   - format.parse((o2[0])).getTime() ))
                            return 1;
                        else return 0;
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return 0;
                }
            });
            answer = list.get(0)[2];
        }
        // 리스트 사이즈 1이면, answer은 그 리스트의 배열의 2번째 인덱스
        else if (list.size() == 1) answer = list.get(0)[2];
        // 리스트 사이즈 0이면, "(None)" 반환
        else answer = "(None)";
        return answer;
    }
}
