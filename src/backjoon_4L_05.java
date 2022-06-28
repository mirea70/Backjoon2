import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjoon_4L_05 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] score = new double[N];

        for (int i = 0; i < N; i++) {
            score[i] = Double.parseDouble(st.nextToken());
        }
        double max = Arrays.stream(score).max().getAsDouble();
        for (int i = 0; i < N; i++) {
            score[i] = score[i]/max*100;
        }
        System.out.println(Arrays.stream(score).average().getAsDouble());

    }
}
