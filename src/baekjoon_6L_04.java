import java.util.Scanner;

public class baekjoon_6L_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int cnt = 0;

        while (cnt < T){
            int R = sc.nextInt();
            char[] words = sc.next().trim().toCharArray();
            for(char w : words) {
                for (int i = 0; i < R; i++) {
                    System.out.print(w);
                }
            }
            System.out.println();
            cnt++;
        }
        sc.close();
    }
}
