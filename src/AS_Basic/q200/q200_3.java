package AS_Basic.q200;

import java.io.*;
import java.util.Stack;

public class q200_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        // 괄호의 순서가 맞아야 한다
        // 괄호의 개수가 맞아야 한다
        boolean chk;
        for (int i = 0; i < T; i++) {
            chk = chkVPS(br.readLine());
            bw.write(chk ? "YES" : "NO");
            bw.write("\n");
        }
        br.close();
        bw.close();
    }

    private static boolean chkVPS(String PS) {
        Stack<String> stack = new Stack<>();

        for(String v : PS.split("")) {
            if(v.equals(")")) {
                // 요소가 ) 일 때 (가 있으면 그 (를 지운다
                int search_result = stack.indexOf("(");
                if(search_result != -1) stack.remove(search_result);
                // 요소가 ) 일 때 (가 없으면 return false
                else return false;
            } else {
                // 요소가 ( 이면 담는다.
                stack.push(v);
            }
        }
        // 요소를 모두 순회했을때, stack이 비워져 있지 않으면 false
        // 요소를 모두 순회했을때, stack이 비워져 있으면 true 반환
        return stack.empty();
    }
}
