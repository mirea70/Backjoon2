package baekJoon.L6;

import java.util.Scanner;

public class baekjoon_6L_07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder s1 = new StringBuilder(sc.next());
        StringBuilder s2 = new StringBuilder(sc.next());

        s1.reverse();
        s2.reverse();

        System.out.println(Math.max(Integer.parseInt(s1.toString()), Integer.parseInt(s2.toString())));
    }
}