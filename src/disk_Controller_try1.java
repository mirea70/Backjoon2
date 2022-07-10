import java.util.Arrays;

public class disk_Controller_try1 {
    public static void main(String[] args) {
        int[][] jobs = new int[][]{
                {0, 3},
                {1, 9},
                {2, 6}
        };
        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs) {
        // 배열의 두번째 요소가 작은 순서대로 jabs를 정렬하여
        // 순서대로 처리한 경우의 평균시간

        int v = jobs[0][1];
        int[] tmp = new int[1];
        int vs = 0;
        int answer = 0;

        for (int i = 0; i < jobs.length-1; i++) {
            for (int j = i + 1; j < jobs.length; j++) {
                if(jobs[i][1] > jobs[j][1]) {
                    tmp = jobs[i];
                    jobs[i] = jobs[j];
                    jobs[j] = tmp;
                }
            }
        }
        int[] total = new int[jobs.length];
        for (int i = 0; i < jobs.length; i++) {
            if(vs >= jobs[i][0]){
                vs += jobs[i][1];
            } else {
                vs += jobs[i][1] + (jobs[i][0] - vs);
            }
            total[i] = vs - jobs[i][0];
        }
        answer = (int)Arrays.stream(total).average().getAsDouble();
        return answer;
    }
}
