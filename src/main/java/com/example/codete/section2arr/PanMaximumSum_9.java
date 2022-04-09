package com.example.codete.section2arr;

import java.util.Scanner;

public class PanMaximumSum_9 {
    //n*n 격자판 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가장 큰 합을 출력
    public int solution(int n, int[][] arr) {
        int answer = Integer.MIN_VALUE;
        //행들, 열들, 대각선 합중 젤 큰거 answer에 저장
        int sum1 = 0; //행합
        int sum2 = 0; //열합
        for(int i=0; i<n; i++) {
            sum1 = 0; //행합
            sum2 = 0; //열합
            for(int j=0; j<n; j++) {
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);

        }
        sum1 = 0;
        sum2 = 0;
        for(int i=0; i<n; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][n-i-1];
        }
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);

        return answer;
    }

    public static void main(String args[]) {
        PanMaximumSum_9 T = new PanMaximumSum_9();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) {
                arr[i][j] = scanner.nextInt();
            }

        }
        System.out.println(T.solution(n, arr));
        
    }
}
