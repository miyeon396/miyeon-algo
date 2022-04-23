package com.example.codete.section3utilization;

import java.util.Scanner;

public class SumOfContinuousSubArr_4 {
    // N개의 수로 이루어진 수열.
    // 이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램
    // N=8 M=6 -> 1 2 1 3 1 1 1 2 -> 2 1 3 / 1 3 1 1 / 3 1 1 1 -> 3가지
    // 얘도 또한 이중포문이 돌면 복잡도가 O의 N 제곱.. 이건 슬라이딩 윈도우는 O의 N제곱을 O의 N으로 해결하는 능력을 배우는 것임.
    // two pointers를 씀. lt부터 rt까지의 합을 씀. sum이 6이되는지를 확인. lt부터 rt까지의 부분 수열의 합.
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int sum = 0;
        int lt = 0;
        for(int rt=0; rt<n; rt++) {
            sum+=arr[rt];
            if(sum == m) answer++; //lt부터 rt까지
            while(sum >= m) {
                sum-=arr[lt++]; //sum에서 arr[lt]뻬고 lt는 하나 증가
                if(sum==m) answer++;
            }
        }

        return answer;
    }

    public static void main(String args[]) {
        SumOfContinuousSubArr_4 T = new SumOfContinuousSubArr_4();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(T.solution(n, m, arr));
        
    }
}
