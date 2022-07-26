package baekJoon;

import java.util.Scanner;

public class baekjoon_6L_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int max = 0;

        char[] arr = sc.next().toCharArray();
        for(char v : arr){
            max += Character.getNumericValue(v);
        }
        System.out.println(max);
    }
}
