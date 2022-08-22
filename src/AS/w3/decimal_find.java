package AS.w3;

import java.util.TreeSet;

public class decimal_find {
    public static void main(String[] args) {

    }
}
class Solution {
    TreeSet<Integer> ts = new TreeSet<>();

    public int decimal_find_solution(String numbers) {
        int answer = 0;
        int check;
        int i;
        func("", numbers);

        return answer;
    }
    // 소수 판별 메서드


    // numbers : 01234
    // number : 01234 / 1234 / 234
    // s : 01234
    // ts : 1234
    private void func(String s, String number) {
        if(number.length() == 0) {
            if(!s.equals(""))
                ts.add(Integer.parseInt(s));
        } else {
            for (int i = 0; i < number.length(); i++)
                func(s + number.charAt(i), number.substring(0, i) + number.substring(i+1, number.length()));
            for (int i = 0; i < number.length(); i++)
                func(s , number.substring(0, i) + number.substring(i+1, number.length()));
        }
    }
}