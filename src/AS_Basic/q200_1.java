package AS_Basic;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q200_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int row = Integer.parseInt(br.readLine());
        String[] arr;
        stack st = new stack();
        st.numStack = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            arr = br.readLine().split(" ");
//            System.out.println("arr[0] = " + arr[0]);
            switch (arr[0]) {
                case "push": st.push(Integer.parseInt(arr[1]));
                    break;
                case "pop": bw.write(st.pop() + "\n");
                    break;
                case "size": bw.write(st.size() + "\n");
                    break;
                case "empty": bw.write(st.empty() + "\n");
                    break;
                case "top": bw.write(st.top() + "\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}

class stack {
    List<Integer> numStack;

    public void push(int num) {
        numStack.add(num);
    }

    public int pop() {
        if(numStack.isEmpty()) {
            return -1;
        } else {
           return numStack.remove(numStack.size() - 1);
        }
    }

    public int size() {
        return numStack.size();
    }

    public int empty() {
        return numStack.isEmpty() ? 1 : 0;
    }

    public int top() {
        return numStack.isEmpty() ? -1 : numStack.get(numStack.size() - 1);
    }
}
