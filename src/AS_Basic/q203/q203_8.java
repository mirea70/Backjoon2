package AS_Basic.q203;

import java.math.BigInteger;
import java.util.Scanner;

public class q203_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] arr = sc.nextLine().split(" ");
        int[] ns = new int[2];
//        ns[0] = Integer.parseInt(arr[0] + arr[1]);
//        ns[1] = Integer.parseInt(arr[2] + arr[3]);

        BigInteger n1 = new BigInteger(arr[0] + arr[1]);
        BigInteger n2 = new BigInteger(arr[2] + arr[3]);

        System.out.print(n1.add(n2));
    }
}
