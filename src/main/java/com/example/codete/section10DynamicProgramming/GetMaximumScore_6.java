package com.example.codete.section10DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class GetMaximumScore_6 {
    // 최대 점수 구하기 (냅색 알고리즘) -> dynamic 더 좋은걸로 갱신해나감

    // N개의 문제를 풀어보려고 함. 각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 된다.
    // 제한시간 M안에 N개의 문제중 최대점수를 얻을 수 있도록 해야함. // 해당 문제는 해당 시간이 걸리면 푸는걸로 간주. 한 유형당 한개만 풀 수 있음

    // 입력
    // 첫줄에 문제 개수 N(1<=N<=50) , 제한시간 M(10<=M<=300)
    // 둘째줄에 N줄에 걸쳐 문제 풀었을 때의 점수와 푸는데 걸리는 시간이 주어짐

    // 출력
    // 첫 줄에 제한시간안에 얻을 수 있는 최대 점수를 출력

    // ex) 5 20 / 10 5 / 25 12 / 15 8 / 6 3 / 7 4 -> 41

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] dy = new int[m+1];

        for (int i=0; i<n; i++) {
            int ps = scanner.nextInt();
            int pt = scanner.nextInt();
            // 하나 읽어서 읽을 떄마다 처리
            for (int j=m; j>=pt; j--) {
                dy[j] = Math.max(dy[j], dy[j-pt]+ps);
            }
        }
        System.out.println(dy[m]);

    }
}

