package AS.w9;

import java.util.*;
import java.util.stream.Collectors;

public class New_Id2 {
    public static void main(String[] args) {
        solve sol = new solve();

        String new_id = "a......b.+*";
        System.out.println(sol.solution(new_id));
    }
}

class solve {
    public String solution(String new_id) {
        String answer = "";
        // 1단계 모든 대문자를 대응되는 소문자로 치환
        List<Character> chList = new_id.chars().mapToObj(ch -> (char)ch).collect(Collectors.toList());
        int index = 0;

        for(char c : chList) {
            if (Character.isUpperCase(c)) chList.set(chList.indexOf(c), Character.toLowerCase(c));
        }

        // 2단계 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        Queue q = new LinkedList();
        q.add(' ');
        while (!q.isEmpty()) {
            q.poll();
                for (char cc : chList) {
                    if (!(((int)cc >= 97 && (int)cc <= 122) || ((int)cc >= 48 && (int)cc <= 57) || (int)cc == 45 || (int)cc == 46 || (int)cc == 95))
                        q.add(cc);
            }
                chList.remove(q.poll());
            }

        // 3단계 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
//        q.add('.');
        for (int i = 1; i < chList.size(); i++) {
            if ((chList.get(i) == '.' && chList.get(i-1) == '.')) q.add(chList.get(i));
        }

        while (!q.isEmpty()) {
            chList.remove(chList.indexOf(q.poll()));
        }
//        ArrayList<Integer> delete = new ArrayList<>();
//        for (int i = 1; i < chList.size(); i++) {
//            if ((chList.get(i) == '.' && chList.get(i-1) == '.')) delete.add(i);
//        }
//
//        for(int i = delete.size() - 1; i >= 0; i--){
//            chList.remove((int) delete.get(i));
//        }

        // . 다없어지는 거해결

        // 4단계 마침표(.)가 처음이나 끝에 위치한다면 제거

        if(chList.get(0) == '.') chList.remove(0);

        if(!chList.isEmpty() && chList.get(chList.size()-1) == '.') chList.remove(chList.size()-1);
        // --> while문으로 바꿔보기

        // 5단계 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(chList.size() == 0) chList.add('a');
        // 6단계 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
        while(chList.size() >= 16) chList.remove(chList.size() -1);

        while(chList.get(chList.size()-1) == '.') chList.remove(chList.size()-1);
        // 7단계 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        while (chList.size() <= 2) chList.add(chList.get(chList.size()-1));

        StringBuilder sb = new StringBuilder();

        for (char c3 : chList) sb.append(c3);

        answer = sb.toString();

        return answer;
    }
}