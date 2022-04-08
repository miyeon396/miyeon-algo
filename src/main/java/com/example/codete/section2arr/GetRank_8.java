package com.example.codete.section2arr;

import java.util.Scanner;

public class GetRank_8 {
    // 등수를 학생 입력 순서대로 출력.
    // 같은 점수가 입력될 경우 높은 등수로 처리. 가장 높은 점수가 99점인데 99점이 3명이면 1등 3명 다음학생 4등
    // 첫줄에 n 입력, 두번째 줄에 국어점수 N개 정수 입력
    public int[] solution(int n, int[] arr) {
        int[] answer = new int[n];
        //이중포문 하나씩 점수들 비교
        for(int i=0; i<n; i++) {
            int cnt = 1; //일단 1등으로 초기화
            for(int j=0; j<n; j++) {
                if(arr[j] > arr[i]) cnt++;
            }
            answer[i] = cnt;

        }

        return answer;
    }

    public static void main(String args[]) {
        GetRank_8 T = new GetRank_8();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        for(int x : T.solution(n, arr)) System.out.println(x+" ");
        
    }
}
