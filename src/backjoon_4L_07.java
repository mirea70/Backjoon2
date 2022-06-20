import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_4L_07 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int cnt = 0;
        int column = 0;
        double max;
        double div;
        double avg = 0;
        double rate = 0;
        StringTokenizer st;
        while (cnt < T){
            max = 0;
            div = 0;
            st = new StringTokenizer(br.readLine());
            column = Integer.parseInt(st.nextToken());
            double[] row = new double[column];
            for (int i = 0; i < row.length; i++) {
                row[i] = Double.parseDouble(st.nextToken());
                max += row[i];
            }
            avg = max / column;
            for (int i = 0; i < row.length; i++) {
                if(row[i] > avg) div++;
            }
            rate = div / column * 100;
            System.out.println(String.format("%.3f",rate) + "%");
            cnt++;
        }
        br.close();
    }
}

