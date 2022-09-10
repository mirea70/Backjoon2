package baekJoon.L3;

import java.io.*;
import java.util.StringTokenizer;

public class backjoon_3L_12 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int A = 1;
        int B = 1;

        while(true){
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            if(A == 0 && B == 0) {
                break;
            }
            bw.write((A+B)+"\n");
        }
        bw.close();
    }
}
