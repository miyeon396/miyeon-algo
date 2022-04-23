package com.example.codete.section3utilization;

import java.util.Scanner;

public class SumOfNumUseTwoPointers_5 {
    // 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 가짓수 출력
    // ex) n = 15 -> 7+8=15, 4+5+6=15, 1+2+3+4+5=15 -> 3
    // n을 2로 나누고 +1한 수까지만 연속된 자연수가 있으면 됨. ex) 15/2 = 7+1 (8+9는 안되니까)
    // two pointer 알고리즘 써서 슬라이딩 윈도우 방식으로 하고 있는데 이처럼 lt rt로 쓸 수 있음 이문제도. 연속 부분수열의 합이라고 생각해도 됨.
    // ex) 1 2 3 4 5 6 7 8 까지만 있음 됨. 15로 2로 나눈 몫 더하기 1까지만 배열에다 넣고 lt rt로 더하면 됨.

    public int solution(int n) {
        int answer = 0;
        int sum = 0;
        int lt = 0;
        int m = (n / 2) +1;
        int[] arr = new int[m];
        for(int i=0; i<m; i++) {
            arr[i] = i+1;
        }
        for(int rt=0; rt<m; rt++) {
            sum+=arr[rt];
            if(sum == n) answer++;
            while(sum >=n) {
                sum-=arr[lt++];
                if(sum == n) answer++;
            }
        }


        return answer;
    }

    public static void main(String args[]) {
        SumOfNumUseTwoPointers_5 T = new SumOfNumUseTwoPointers_5();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(T.solution(n));
        
    }
}
