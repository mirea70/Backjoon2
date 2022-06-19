import java.io.BufferedReader;
import java.io.InputStreamReader;

public class backjoon_4L_04  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = new int[10];
        int[] chk = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        int n = 0;
        int cnt = 0;
        for (int i = 0; i < 10; i++) {
            n = Integer.parseInt(br.readLine());
            num[i] = n % 42;
        }
       outer: for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < chk.length; j++) {
                if(num[i] == chk[j]) continue outer;
                }
            chk[i] = num[i];
            cnt++;
            }
        System.out.println(cnt);
        }
    }
