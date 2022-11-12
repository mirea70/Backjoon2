package AS_Basic.q200;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class q200_8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        String[] arr;
        customDeque deque = new customDeque();

        deque.list = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            arr = br.readLine().split(" ");

            switch (arr[0]) {
                case "push_front" : deque.push_front(Integer.parseInt(arr[1]));
                    break;
                case "push_back" : deque.push_back(Integer.parseInt(arr[1]));
                    break;
                case "pop_front" : bw.write(deque.pop_front() + "\n");
                    break;
                case "pop_back" : bw.write(deque.pop_back() + "\n");
                    break;
                case "size" : bw.write(deque.size() + "\n");
                    break;
                case "empty" : bw.write(deque.empty() + "\n");
                    break;
                case "front" : bw.write(deque.front() + "\n");
                    break;
                case "back" : bw.write(deque.back() + "\n");
                    break;
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}

class customDeque {
    List<Integer> list;

    public void push_front(int X) {
        list.add(0, X);
    }
    public void push_back(int X) {
        list.add(X);
    }
    public int pop_front() {
        if(!list.isEmpty()) return list.remove(0);
        else return -1;
    }
    public int pop_back() {
        if(!list.isEmpty()) return list.remove(list.size() - 1);
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