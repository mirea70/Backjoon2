import java.util.Scanner;

public class backjoon_4L_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int mult = A * B * C;
        int[] cnt = new int[10];
        String str = String.valueOf(mult);
        char vs = '0';

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < 10; j++) {
                vs = (char)(j + '0');
                if(str.charAt(i) == vs) cnt[j]++;
            }
        }
        for(int result : cnt) System.out.println(result);
    }
}
