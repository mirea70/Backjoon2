package baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class backjoon_3L_14 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int new_N = N;
        int first = 0;
        int second = 0;
        int sum = 0;

        while(true) {
            first = new_N / 10;
            second = new_N % 10;
            sum = first + second;
            new_N = (second * 10) + (sum % 10);
            count++;
            if(new_N == N) break;
        }
//        } while(new_N != N);
        bw.write(count + "");
        bw.flush();
        bw.close();
//        br.close();
    }
}
