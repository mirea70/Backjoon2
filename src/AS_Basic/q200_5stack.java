package AS_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class q200_5stack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stL = new Stack<>();
        Stack<Character> stR = new Stack<>();
        char[] str = br.readLine().toCharArray();
        for(char v : str)
            stL.push(v);

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            if(input.equals("L") && !stL.empty()) stR.push(stL.pop());
            else if(input.equals("D") && !stR.empty()) stL.push(stR.pop());
            else if(input.equals("B") && !stL.empty()) stL.pop();
            else if(input.contains("P")) stL.push(input.charAt(2));
        }

        while (!stL.empty()) stR.push(stL.pop());

        StringBuilder sb = new StringBuilder();

        while (!stR.empty()) sb.append(stR.pop());

        System.out.print(sb);
    }
}
