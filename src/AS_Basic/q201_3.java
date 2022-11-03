package AS_Basic;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class q201_3 {
    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        // 순열 arr
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Stack<Integer> stack = new Stack<>();
        // 0번 인덱스 푸시
        stack.push(0);
        // 1번 인덱스 부터 순열을 순회
        for (int i = 1; i < arr.length; i++) {
            // stack의 top 인 것과 비교해서 현재 값이 크지 않으면 그 인덱스 푸시
            if(arr[i] <= arr[stack.peek()]) stack.push(i);
            // stack의 top보다 크면, top보다 작거나 같을때까지(인덱스가 0이면 멈춘다) pop해서 해당 인덱스로 배열 초기화
            else {
                while (!stack.empty() && arr[i] > arr[stack.peek()]) arr[stack.pop()] = arr[i];
                stack.push(i);
            }
        }
        // 반복문이 끝났을 때, stack이 남아있다면 그 인덱스는 오큰수가 없다는 뜻 : -1로 채운다.
        while (!stack.empty()) arr[stack.pop()] = -1;
//        System.out.println("arr = " + Arrays.toString(arr));
        // 배열을 StringBuilder로 공백단위로 채우기
        StringBuilder sb = new StringBuilder();
        for(int v : arr) sb.append(v).append(' ');
        // StringBuilder 출력
        System.out.print(sb);
    }
}
