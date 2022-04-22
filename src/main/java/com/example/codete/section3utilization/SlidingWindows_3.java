package com.example.codete.section3utilization;

import java.util.Scanner;

public class SlidingWindows_3 {
    //N일 동안의 매출기록 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 함.
    //N = 10, 10일간의 매출기록 아래와 같음 k=3일 때, 연속 3일간 최대 매출액 구하기
    // 12 15 11 20 25 10 20 19 13 15 -> 11 + 20 + 25 = 56
    //sliding window라고 하는게 길이가 3인 창문 만들어서 옆으로 밀고 가면 끝나는 것. (이중포문 돌면 O의 N제곱)
    public int solution(int n, int k, int[] a) {
        int answer = 0;
        int sum = 0;
        for(int i=0; i<k; i++) sum+=a[i];
        answer = sum;
        for(int i=k; i<n; i++) {
            sum+=(a[i]-a[i-k]);
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    public static void main(String args[]) {
        SlidingWindows_3 T = new SlidingWindows_3();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(T.solution(n, k, a));
        
    }
}
