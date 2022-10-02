package AS.kakao1;

public class q2 {
    public static void main(String[] args) {
        int cap = 4;
        int n = 5;
        int[] deliveries = new int[] {
            1,0,3,1,2
        };
        int[] pickups = new int[] {
                0,3,0,4,0
        };
        Solution s = new Solution();
        System.out.println(s.solution(cap, n, deliveries, pickups));
    }
}

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int dBox = 0;
        int pBox = 0;
        long d = 0;
        boolean[] dCk = new boolean[n];
        boolean[] pCk = new boolean[n];
        boolean ck = false;
        for(int i = 0; i < deliveries.length; i++) {
            if(deliveries[i] == 0) dCk[i] = true;
            if(pickups[i] == 0) pCk[i] = true;
        }

        while(!ck) {
            ck = true;
            for(int i = 0; i < deliveries.length; i++) {
                if(!dCk[i] || !pCk[i]) ck = false;
            }

            int startIdx = 0;
            for(int i = n - 1; i >= 0; i--) {
                if(!dCk[i] || !pCk[i] ) {
                    startIdx = Math.max(startIdx, i);
                    break;
                }
            }

            dBox = cap;
            pBox = 0;
            for(int i = startIdx; i >= 0; i--) {
                if(!dCk[i] && dBox > 0 && deliveries[i] != 0) {
                    while(deliveries[i] != 0) {
                        deliveries[i]--;
                        dBox--;
                        if(dBox == 0) break;
                    }
                    if(deliveries[i] == 0) dCk[i] = true;
                    d = Math.max(i + 1, d);
                }

                if(!pCk[i] && pBox < cap && pickups[i] != 0) {
                    while(pBox < cap) {
                        pickups[i]--;
                        pBox++;
                        if(pickups[i] == 0) break;
                    }
                    if(pickups[i] == 0) pCk[i] = true;
                    d = Math.max(i + 1, d);
                }
            }
            answer += (2 * d);
            d = 0;
        }
        return answer;
    }
}