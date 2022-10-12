package AS_Basic;

import java.io.*;
import java.util.Arrays;

public class q200_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb;

        for (int i = 0; i < T; i++) {
            String[] word_arr = br.readLine().split(" ");
            for(String word : word_arr) {
                sb = new StringBuffer(word);
                word = sb.reverse().toString();
                bw.write(word + " ");
            }
            bw.write("\n");
//            System.out.println(Arrays.toString(word_arr));
        }
        br.close();
        bw.close();
    }
}
