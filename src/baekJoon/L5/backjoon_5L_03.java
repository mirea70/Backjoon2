package baekJoon.L5;

import java.util.ArrayList;
import java.util.Scanner;

public class backjoon_5L_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        System.out.println(han(N));
    }
    static int han(int n) {
        ArrayList list = new ArrayList();
        for (int i = 1; i <= n; i++) {
            if(i < 100) {
                list.add(i);
            } else if (i < 1000) {
                if((i / 100) - ((i % 100) / 10) == (((i % 100) / 10) - (i % 10))){
                    list.add(i);
                }
            }
        }
        return list.size();
    }
}
