package com.example.codete.section2arr;

import java.util.Scanner;

public class ScoreCalc_7 {
    //문제 여러번 연속해서 맞춘 경우 +1 1+2+3+...+k 틀린경우 0 그 다음 다시 맞춘 경우 1부터
    // 채점 결과가 주어졌을 때 총 점수를 계산하는 프로그램 작성
    // 채점 1 0 1 1 1 0 0 1 1 0
    // 결과 1 0 1 2 3 0 0 1 2 0
    public int solution(int n, int[] arr) {
        int answer = 0;
        int cnt = 0;

        for(int i=0; i<n; i++) {
            if(arr[i] == 1) {
                cnt ++;
                answer += cnt;
            }
            else cnt = 0;
        }


        return answer;
    }

    public static void main(String args[]) {
        ScoreCalc_7 T = new ScoreCalc_7();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(T.solution(n, arr));

    }
}
