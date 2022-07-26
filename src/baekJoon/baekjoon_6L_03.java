package baekJoon;

import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon_6L_03 {
    public static void main(String[] args) {

        String al = "abcdefghijklmnopqrstuvwxyz";

        Scanner sc = new Scanner(System.in);
        String in = sc.next();
        for (int i = 0; i < al.length(); i++) {
            System.out.print(in.indexOf(al.charAt(i)) + " ");
        }
    }
}
