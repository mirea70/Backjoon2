package AS.w1;

import java.util.StringTokenizer;

public class curiousLetter {
    public static void main(String[] args) {
        curiousLetter_Solution c = new curiousLetter_Solution();
        System.out.println(c.solution("try hello world"));
    }
}
class curiousLetter_Solution {
    public String solution(String s) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s, " ", true);
//        String[] arr = s.split("\\s+", -1);

        while (st.hasMoreTokens()){
            String value = st.nextToken();

                for (int j = 0; j < value.length(); j++) {

                    if(value.charAt(j) == ' ') {
                        sb.append(value.charAt(j));
                        continue;
                    }
                    if(j % 2 == 0) sb.append(Character.toUpperCase(value.charAt(j)));
                    else sb.append(Character.toLowerCase(value.charAt(j)));
                }
                answer += sb.toString();

                sb.setLength(0);
            }
        return answer;
    }
}