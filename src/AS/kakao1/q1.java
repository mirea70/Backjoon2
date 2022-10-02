import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) throws ParseException {
        // 넣어야할 번호 담긴 리스트 추가
        ArrayList<Integer> list = new ArrayList<>();
        // privacies를 순회
        for(int i = 0; i < privacies.length; i++) {
            // terms에서 맞는 약관을 찾는다.
            for(int j=0; j < terms.length; j++) {
                String[] P = privacies[i].split(" ");
                String[] T = terms[j].split(" ");

                if(P[1].equals(T[0])) {
                    // 맞는 약관에 들어있는 개월 수 만큼 privacies의 날짜를 더한다
                    // today와 비교하여 유효기간 지났는지 체크
                    // 지났으면 해당 번호를 리스트에 추가
                    int start = Integer.parseInt(P[0].split("\\.")[1]);
                    int add = Integer.parseInt(T[1]);
                    int oD = Integer.parseInt(P[0].split("\\.")[2]);
                    int mD = oD == 1 ? 28 : oD - 1;
                    int m = mD == 28 ? start + add - 1 : start + add;
                    int y;
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
                    Date now = dateFormat.parse(today);

                    if(start + add <= 12) {
                        String addP = P[0].split("\\.")[0] + "." + String.valueOf(m) + "." + String.valueOf(mD);
                        Date srart_time = dateFormat.parse(addP);
                        int compare = srart_time.compareTo(now);

                        if(compare < 0) list.add(i + 1);
                    } else if(start + add > 12 && start + add <= 24) {
                        y = Integer.parseInt(P[0].split("\\.")[0]) + 1;
                        String addP = String.valueOf(y) + "." + String.valueOf(m - 12) + "." + String.valueOf(mD);
                        Date srart_time = dateFormat.parse(addP);
                        int compare = srart_time.compareTo(now);

                        if(compare < 0) list.add(i + 1);
                    } else {
                        y = Integer.parseInt(P[0].split("\\.")[0]) + 2;
                        String addP = String.valueOf(y) + "." + String.valueOf(m - 24) + "." + String.valueOf(mD);
                        Date srart_time = dateFormat.parse(addP);
                        int compare = srart_time.compareTo(now);

                        if(compare < 0) list.add(i + 1);
                    }
                }
            }
        }
        // 순회 종료
        // answer을 리스트 크기만큼 정의
        // 리스트를 순회하며 answer에 넣는다.
        int[] answer = new int[list.size()];

        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}