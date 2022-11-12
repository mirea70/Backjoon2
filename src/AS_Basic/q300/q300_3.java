package AS_Basic.q300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q300_3 {
    public static void main(String[] args) throws IOException {
        // 전처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int a = 0;
        int b = 0;

//      최대공약수를 구한 뒤 구하기
        int gcd = 0;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine()," ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            gcd = gcd(a , b);
            System.out.println(a * b / gcd);
        }
        br.close();
        br.close();
    }
    // 최대공약수 함수
    private static int gcd(int a, int b) {
        if(b == 0) return a;

        return gcd(b, a % b );
    }
}
