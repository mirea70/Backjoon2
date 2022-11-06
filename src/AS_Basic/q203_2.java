package AS_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class q203_2 {
    public static void main(String[] args) throws IOException {
        // 전처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();
        // line 순회
        for(char now : line) {
            // stack의 top보다 현재 연산자가 우선순위가 낮거나 같으면, 현재가 높을때까지 연산자를 pop 출력시킨다.
            switch (now) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while(!stack.isEmpty() && priority(stack.peek()) >= priority(now))
                        answer.append(stack.pop());
                    stack.push(now);
                    break;
                case '(': stack.push(now);
                break;
                case ')': while(!stack.isEmpty() && stack.peek() != '(') answer.append(stack.pop());
                stack.pop();
                break;
                default: answer.append(now);
            }
        }
        // 반복문 끝
        // 스택 남아있으면, 빌때까지 pop 출력
        while (!stack.isEmpty()) answer.append(stack.pop());
        // answer 출력
        System.out.print(answer);
    }
    // 우선순위 출력하는 메서드
    static private int priority(char operator) {
        if(operator == '+' || operator == '-') return 1;
        else if (operator == '*' || operator == '/') return 2;
        else return -1;
    }
}
