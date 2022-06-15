import java.io.*;
import java.util.StringTokenizer;

public class backjoon_3L_11 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int tmp = 0;
        for (int i = 0; i < N; i++) {
            tmp = Integer.parseInt(st.nextToken());
            if(tmp < X) bw.write(tmp + " ");
        }
        bw.close();
    }
}
