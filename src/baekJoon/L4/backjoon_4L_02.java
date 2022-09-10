package baekJoon.L4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


        public class backjoon_4L_02 {
            public static void main(String[] args) throws IOException {
                // 순회할 배열 생성
                // int 생성 후 첫 인덱스(기준점)  대입
                // 1번 인덱스부터 기준점과 비교 후, 크면 max에 담음
                // 순회할 때마다 배열에 그 값을 넣어줌
                // 반복문이 끝난후 만들어진 배열의 max에 해당하는 인덱스값 찾아 저장
                // 첫째줄에 최댓값, 둘째줄에 인덱스 출력
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                int[] arr = new int[9];
                for (int i = 0; i < 9; i++) {
                    arr[i] = Integer.parseInt(br.readLine());
                }
                int count = 0;
                int max = 0;
                int index = 0;

                for (int value : arr) {
                    count++;
                    if(value > max){
                        max = value;
                        index = count;
                    }
                }
//        br.close();
                System.out.println(max);
                System.out.println(index);
            }
        }

