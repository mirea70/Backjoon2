package AS_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class q201_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 문자열을 Caracter 배열로 변환
        char[] input_arr = br.readLine().toCharArray(); 
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean tag_ck = false;
        boolean stack_ck = false;
        // 배열 순회
        for(char c : input_arr) {
            // < 이면 > 나올 때까지 StringBuilder에 그대로 추가
            // 일반 문자이면 공백이 나올때까지 StringBuilder에 추가
            // stack에 들어간 값을 pop 한 걸 StringBuilder에 추가
            if(c == '<') {
                if(!stack.empty()) {
                    while (!stack.empty()) sb.append(stack.pop());
                }
                sb.append(c);
                tag_ck = true;
                stack_ck = false;
            } else if (c == '>') {
                sb.append(c);
                tag_ck = false;
            } else if (tag_ck) {
                sb.append(c);
            } else if (c != ' ') {
                stack_ck = true;
                stack.push(c);
//            } else if (c != ' ' && stack_ck) {
//                stack.push(c);
            } else if(c == ' ') {
                while (!stack.empty()) {
                    sb.append(stack.pop());
                }
                sb.append(' ');
                stack_ck = false;
            }
        }
        // 순회 끝
        if(!stack.empty()) {
            while (!stack.empty()) sb.append(stack.pop());
        }
        // StringBuilder 출력
        System.out.print(sb);
    }
}