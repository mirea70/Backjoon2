package AS.w10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class meeting {
    public static void main(String[] args) throws IOException {
        // 전처리
        int[] meet = new int[2];
        List<int[]> list = new ArrayList<>();
        int cnt = 0;
        int last_Time = 0;
        // 입력값들을 두개씩 배열로 만들어, 리스트에 담는다.
        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bw.readLine());
        for (int i = 0; i < T; i++) {
            meet = Arrays.stream(bw.readLine().split(" ")).mapToInt(a -> Integer.parseInt(a)).toArray();
            list.add(meet);
        }
        // 리스트 0번인덱스 기준 정렬
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] > o2[0]) ? 1 : (o1[0] < o2[0]) ? -1 : 0;
            }
        });
        // 리스트를 1번인덱스 기준으로 정렬한다.
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1] > o2[1]) ? 1 : (o1[1] < o2[1]) ? -1 : 0;
            }
        });
//        System.out.println(Arrays.toString(list.get(2)));
        // cnt ++ (첫 요소 시작)
        last_Time = list.get(0)[1];
        cnt++;
        // 리스트를 순회하며 0번인덱스 값이 전 것의 1번인덱스 값 이상이면 cnt ++
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i)[0] >= last_Time) {
                last_Time = list.get(i)[1];
                cnt++;
            }
        }
        // 순회 끝, cnt 출력
        System.out.println(cnt);
    }
}