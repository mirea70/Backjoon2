package AS_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class q203_1 {
    public static void main(String[] args) throws IOException {
        // 전처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 첫줄 수 N 저장
        int N = Integer.parseInt(br.readLine());
        // N 크기로 피연산자 배열 생성
        double[] nums = new double[N];
        // 피연산자 인덱스 맵
        Map<Character, Integer> n_idx = new HashMap<>();
        // 피연산자 벨류 인덱스
        int i = 0;
        // 스택 생성
        Stack<Double> stack = new Stack<>();
         // 스택 임시 변수
        double stack_temp;
        // 결과 저장 변수
        double answer = 0;
        // 둘째줄을 calculate 배열로 저장(ch)
        char[] calculate = br.readLine().toCharArray();
        // calculate 배열 순회
        for(char ch : calculate) {
            // 연산자가 아니라면 다음 줄을 받아 피연산자 맵에 저장, 피연산자 인덱스 배열에 해당 문자 저장, 스택에 그 수를 푸시
            if(!(ch == '*' || ch == '+' || ch == '/' || ch == '-')) {
                // 피연산자 인덱스 문자가 존재하던 것이 아니라면
                if(!n_idx.containsKey(ch)) {
                    n_idx.put(ch,i);
                    nums[n_idx.get(ch)] = Integer.parseInt(br.readLine());
                    i++;
                }
                stack.push(nums[n_idx.get(ch)]);
            }
            else {
                // 연산자라면 스택 pop한 값을 임시 변수에 저장, 다음 pop한 값과 해당 연산자로 연산한 뒤 결과 변수에 저장
                stack_temp = stack.pop();
                switch (ch) {
                    case '*': stack.push(stack.pop() * stack_temp);
                        break;
                    case '+': stack.push(stack.pop() + stack_temp);
                        break;
                    case '/': stack.push(stack.pop() / stack_temp);
                        break;
                    case '-': stack.push(stack.pop() - stack_temp);
                        break;
                }
            }
        }
        // 순회 끝
        // 결과 변수 출력
        System.out.printf("%.2f", stack.pop());
    }
}
