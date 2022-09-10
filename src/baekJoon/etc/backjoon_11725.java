package baekJoon.etc;

import java.util.ArrayList;
import java.util.Scanner;

public class backjoon_11725 {
    public static void main(String[] args) {
        // 1 들어온 연결점 트리 만들기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt() - 1;
        ArrayList tree = new ArrayList();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                tree.add(sc.nextInt());
            }
            tree.add(0);
        }
        // 2 완성 트리 만들기
        // 묶음 set 생성
        // 기존 트리에서 1을 찾는다.
        // 1의 연결점을 찾는다. -> 1의 직전 인덱스 != 0이면 set에 담는다

        Object a = new Object();

    }
}
