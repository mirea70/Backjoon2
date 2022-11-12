package AS_Basic.q200;

import java.io.*;
import java.util.Stack;

public class q200_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        // 현재 상태에서 그 숫자를 출력할 수 있는지 판단 : stack의 head가 그숫자냐
        stack.push(0);
        int i = 1;
        outer:
        for (int j = 0; j < n; j++) {
            int num = Integer.parseInt(br.readLine());
            while (true) {
                // 입력받은 숫자보다 현재 head가 작으면 : push
                if(stack.peek() < num) {
                    stack.push(i);
                    result.append("+\n");
                    i++;
                }
                // 입력받은 숫자와 head가 같으면 : pop
                else if(stack.peek() == num) {
                    stack.pop();
                    result.append("-\n");
//                        String temp = br.readLine();
//                        if(!temp.equals("")) num = Integer.parseInt(temp);
                    break;
//                        if(num == null) break;
                    // 입력받은 숫자보다 현재 head가 크면 : NO
                } else {
                    result.setLength(0);
                    result.append("NO");
                    break outer;
                }
                if(stack.size() == 1 && i == n) break;
            }
        }
        bw.write(result.toString());
        br.close();
        bw.close();
    }
}
