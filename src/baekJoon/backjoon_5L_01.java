package baekJoon;

import java.math.BigInteger;

public class backjoon_5L_01 {
    long sum(int[] a) {
        BigInteger max = new BigInteger("0");
        for(int tmp : a) {
           max = max.add(new BigInteger(String.valueOf(tmp)));
        }
        long long_max = max.longValue();
        return long_max;
    }
}

