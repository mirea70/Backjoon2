package baekJoon.L5;

import java.util.ArrayList;

public class backjoon_5L_02 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            list.add(i);
        }
        ArrayList<Integer> rmv = con(list);

        rmv.stream().mapToInt(a -> a)
                .forEach(System.out::println);
    }
    static ArrayList<Integer> con(ArrayList<Integer> l) {
        int n = 1;
        Integer dn = 0;

        do{
            if(n < 100) {
                dn = n + (n / 10) + (n % 10);
            } else if (n <1000) {
                dn = n + (n / 100) + ( (n % 100) / 10) + (n % 10);
            } else if (n < 10000) {
                dn = n + (n / 1000) + ((n % 1000) / 100) + ((n % 100) / 10) + (n % 10);
            }
                    if((l.contains(dn))) l.remove(dn);
            n++;
        }   while(n <= 10000);
        return l;
    }
}
