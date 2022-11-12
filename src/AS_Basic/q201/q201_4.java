package AS_Basic.q201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class q201_4 {

    static final int Max = 1_000_001;
    public static void main(String[] args) throws IOException {
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 수열 index를 저장
        int[] index = new int[N];
        // 등장횟수는 count
        int[] count = new int[Max];

        StringTokenizer st = new StringTokenizer(br.readLine());

        // N번만큼 순회하며 index와 count 채우기
        for (int i = 0; i < N; i++) {
            index[i] = Integer.parseInt(st.nextToken());
            count[index[i]]++;
        }
//        System.out.println("count = " + Arrays.toString(count));
        Stack<Integer> stack = new Stack<>();
//        stack.push(0);

        for (int i = 0; i < N; i++) {
                // Stack의 top 보다 현재가 크면 , 현재가 클때 동안까지 Stack의 있는 인덱스를 pop하여 그 인덱스를 현재로 채웁니다.
                while (!stack.empty() && count[index[i]] > count[index[stack.peek()]]) index[stack.pop()] = index[i];
                // 채우는 것이 끝나면 현재 인덱스를 다시 Stack에 push
            // 스택에 현 인덱스 푸시
            stack.push(i);
            }
        // 반복문이 끝났을 때, Stack이 비어있지 않다면, Stack이 빌때까지 pop하여 그 인덱스에 해당하는 수열을 -1로 채웁니다.
        if(!stack.empty()) while (!stack.empty()) index[stack.pop()] = -1;
        // 수열의 배열을 순회하며 StringBuilder에 넣습니다.
        StringBuilder sb = new StringBuilder();
        for(int i : index) sb.append(i).append(' ');
        // StringBuilder 출력
        System.out.print(sb);
    }
}
