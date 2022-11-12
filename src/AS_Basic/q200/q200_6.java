package AS_Basic.q200;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class q200_6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        customQueue queue = new customQueue();
        queue.list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String[] arr;

        for (int i = 0; i < T; i++) {
            arr = br.readLine().split(" ");

//            switch (arr[0]) {
//                case "pop" : sb.append(queue.pop()).append("\n");
//                    break;
//                case "size" : sb.append(queue.size()).append("\n");
//                    break;
//                case "empty" : sb.append(queue.empty()).append("\n");
//                    break;
//                case "front" : sb.append(queue.front()).append("\n");
//                    break;
//                case "back" : sb.append(queue.back()).append("\n");
//                    break;
//                case "push" : queue.push(Integer.parseInt(arr[1]));
//                    break;
//            }

            if(arr[0].equals("pop")) sb.append(queue.pop()).append("\n");
            else if(arr[0].equals("size")) sb.append(queue.size()).append("\n");
            else if(arr[0].equals("empty")) sb.append(queue.empty()).append("\n");
            else if(arr[0].equals("front")) sb.append(queue.front()).append("\n");
            else if(arr[0].equals("back")) sb.append(queue.back()).append("\n");
            else if(arr[0].equals("push")) queue.push(Integer.parseInt(arr[1]));
        }
        System.out.print(sb);
//        br.close();
//        bw.flush();
//        bw.close();
    }
}

class customQueue {
    List<Integer> list;

    public void push(int n) {
        list.add(n);
    }

    public int pop() {
        if(!list.isEmpty()) {
            return list.remove(0);
        }
        else return -1;
    }

    public int size() {
        return list.size();
    }

    public int empty() {
        if(list.isEmpty()) return 1;
        else return 0;
    }

    public int front() {
        if(!list.isEmpty()) return list.get(0);
        else return -1;
    }

    public int back() {
        if(!list.isEmpty()) return list.get(list.size() - 1);
        else return -1;
    }
}
