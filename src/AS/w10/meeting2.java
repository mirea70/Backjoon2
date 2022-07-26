package AS.w10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class meeting2 {
    public static void main(String[] args) throws IOException {
        // 전처리
        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
        int row = Integer.parseInt(bw.readLine());
        int[] temp = new int[2];
        // 맵에 데이터를 넣는다
//        LinkedHashMap<Integer, Integer> map = new LinkedHashMap();
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            temp = Arrays.stream(bw.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//            System.out.println(Arrays.toString(temp));
            Map.Entry<Integer, Integer> m = new AbstractMap.SimpleEntry<>(temp[0],temp[1]);
            entries.add(m);
        }
        bw.close();

        System.out.println(entries.toString());

        // 끝나는시간이 작은순으로 정렬
//        List<Map.Entry<Integer, Integer>>
        entries = entries.stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toList());

//        System.out.println(entries.toString());
        //시작시간이 낮은순으로 정렬
        entries = entries.stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toList());
        System.out.println(entries.toString());

        // 이어붙여진 회의 갯수 = linked, 각 회의를 처음 시작했을 때 이어붙여진 회의 수 = cntArr
        int linked = 0;
        int[] cntArr = new int[entries.size()];
        Stack<Map.Entry<Integer,Integer>> stack = new Stack();

        for (int i = 0; i < entries.size(); i++) {
            // 첫번째부터 이어붙인다. linked++
            stack.push(entries.get(i)); linked++;
            for (int j = i + 1; j < entries.size(); j++) {
            // 끝나는 시간보다 같거나 뒤에 시작하는 놈을 두번째부터 비교하여 이어붙인다.
                if(stack.peek().getValue() <= entries.get(j).getKey()) {
                    stack.push(entries.get(j));
                    linked++;
                }
            }
            cntArr[i] = linked;
            linked = 0;
            stack.clear();
        }
        // map을 다 순회하면 종료,
        // 이어붙여진 회의 수 중 최댓값 구하기
        int max = Arrays.stream(cntArr).max().getAsInt();
        // max 출력
        System.out.print(max);
    }
}