package AS.w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class intern {
    public static void main(String[] args) throws IOException {
        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
        String[] t = bw.readLine().split(" ");
        int N = Integer.parseInt(t[0]);
        int M = Integer.parseInt(t[1]);
        int K = Integer.parseInt(t[2]);

        bw.close();
        // M == 팀의 개수
        // K가 0이될때까지 반복
        while (K > 0) {
            // N <= 2M 이면 M -1
            if(N <= 2 * M) {
                M --;
                K--;
            }
            // N > 2M 이면 N -1
            else {
                N--;
                K--;
            }
        }
        if(N >= 2*M) System.out.println(M);
        else System.out.println(N / 2);
    }
}
