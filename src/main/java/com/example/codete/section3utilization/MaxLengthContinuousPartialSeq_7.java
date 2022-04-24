package com.example.codete.section3utilization;

import java.util.Scanner;

public class MaxLengthContinuousPartialSeq_7 {
    // 0과1로 구성된 길이가 N인 수열. 최대 k번을 0,1로 변경 가능
    // 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대길이 부분수열 찾는 프로그램
    // ex) n 14, k 2 -> 1 1 0 0 1 1 0 1 1 0 1 1 0 1 -> 1 1 0 0 1 1 1 1 1 1 1 1 0 1 -> 8
    // 얘도 결국 two pointers algorithm
    // rt 증가할 때마다 길이 증가. lt는 쫓아가고. 길이 rt - lt + 1

    public int solution(int n, int k, int[] arr) {
        int answer = 0;
        int cnt = 0; //0을 1로 바꾼 횟수
        int lt = 0;

        for(int rt=0; rt<n; rt++) {
            if(arr[rt] == 0) cnt++;
            while(cnt > k) {
                if(arr[lt] == 0) cnt--;
                lt++;
            }
            answer = Math.max(answer, rt-lt+1);
        }

        return answer;
    }

    public static void main(String args[]) {
        MaxLengthContinuousPartialSeq_7 T = new MaxLengthContinuousPartialSeq_7();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int [n];
        for(int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(T.solution(n, k, arr));
    }
}
