package AS_Basic.q300;

import java.util.Scanner;

public class q300_2 {
    public static void main(String[] args) {
        // 전처리
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        // 최대공약수 구하기
        int gcd = gcd(a, b);
        // 최소공배수 구하기
        int lcm = a * b / gcd;
        // 출력
        System.out.println(gcd);
        System.out.print(lcm);
    }
    // 최대공약수 구하는 메서드
    private static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
