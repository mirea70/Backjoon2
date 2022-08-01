package AS.w1;

import java.util.StringTokenizer;

public class curiousLetter2 {
    public static void main(String[] args) {
        curiousLetter_Solution c = new curiousLetter_Solution();
        System.out.println(c.solution("try hello world"));
    }
}
class curiousLetter_Solution2 {
    public String solution(String s) {
        String answer = "";

        int cnt = 0;
        String[] array = s.split("");

        for(String ss : array) {
            cnt = ss.equals(" ") ? 0 : cnt + 1;
            answer += cnt%2 == 0 ? ss.toLowerCase() : ss.toUpperCase();
        }

        return answer;
    }
}