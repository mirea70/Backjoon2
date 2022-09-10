package baekJoon.L4;

import java.util.Scanner;

public class backjoon_4L_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Max = -1000000;
        int Min = 1000000;
        int tmp = 0;

        for (int i = 0; i < N; i++) {
            tmp = sc.nextInt();
            if(tmp > Max) Max = tmp;

            if(tmp < Min) Min = tmp;
        }
        sc.close();
        System.out.print(Min + " " + Max);
    }
}
