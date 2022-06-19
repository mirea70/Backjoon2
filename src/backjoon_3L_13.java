import java.io.*;
import java.util.StringTokenizer;

public class backjoon_3L_13 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String str;

        int A = 0;
        int B = 0;

        while((str=br.readLine()) != null){

            st = new StringTokenizer(str, " ");
//            if(!st.hasMoreTokens()) {
//                bw.flush();
//                break;
//            }
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            bw.write((A+B)+"\n");
        }
        bw.close();
        br.close();
    }
}
