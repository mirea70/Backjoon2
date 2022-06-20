import java.io.BufferedReader;
import java.io.InputStreamReader;

public class backjoon_4L_06 {
    public static void main(String[] args) throws Exception {
//      첫째줄을 입력받아 int N 저장(테스트를 반복할 횟수)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

//      반복문을 돈다(N번) cnt = 0;
//      테스트 문자열 저장할 String str 생성
//      O 점수 저장할 int o
//      점수 합 저장할 int max
//      str 순회 : O면 o++, max += o
//      x면 o = 0;
//      순회 끝
//        sout(max)
//        max = 0;
//        cnt++
        int cnt = 0;
        String str ="";
        int o = 0;
        int max = 0;
        while (cnt < N){
            o = 0;
            max = 0;
            str = br.readLine();
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == 'O') {
                    o++;
                    max += o;
                } else {
                    o = 0;
                }
            }
            System.out.println(max);
            cnt++;
        }
        br.close();
    }
}
