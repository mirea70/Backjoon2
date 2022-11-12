package AS_Basic.q201;

import java.util.Scanner;
import java.util.Stack;

public class q201_2 {
    public static void main(String[] args) {
        // 전처리
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.nextLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int chip = 0;
        int total = 0;
        // 문자열의 char을 stack에 넣는다.
        for(char c : arr) {
            // ( 넣을 때마다 chip + 1, total + 1
            if(c == '(') {
                stack.push(c);
                chip++;
                total++;

            }
            // ) 나오면 head 꺼냈을 때 chip - 1, total + chip
            else if (c == ')') {

                if(stack.peek() == '(') {
                    total--;
                    stack.push(')');
                    chip--;
                    total += chip;
                }
                else {
                    stack.push(')');
                    chip--;
                }
            }
        }
        System.out.print(total);

    }
}