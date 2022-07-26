package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_6L_06 {
    public static void main(String[] args) throws IOException {
        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = bw.readLine().split(" ");
        bw.close();

        if (arr.length != 0) {
            if (arr[0].length() == 0) System.out.println(arr.length - 1);
            else System.out.println(arr.length);
        } else System.out.println(0);
    }
}
