package com.example.codete.section10DynamicProgramming;

import java.util.Scanner;

public class GoStair_1 {
    //계단 오르기
    // 철수는 계단을 오를 때 한번에 한 계단 또는 두 계단 씩 올라간다. 만약 총 4계단을 오른다면 그 방법의 수는
    // 1+1+1+1 / 1+1+2 / 1+2+1 / 2+1+1 / 2+2 로 총 5가지
    // 총 N계단일 때 철수가 올라갈 수 있는 방법의 수는?

    // ex) 7 -> 21

    // 다이나믹 -> 작은 문제로 변환 시키는 것.

    static int[] dy;
    public int solution(int n) {
        dy[1] = 1; //1번째 계단까지 가는 방법의 수
        dy[2] = 2;

        for(int i=3; i<=n; i++) {
            dy[i] = dy[i-2]+dy[i-1];
        }
        return dy[n];

    }

    public static void main(String args[]) {
        GoStair_1 T = new GoStair_1();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        dy = new int[n+1];
        System.out.println(T.solution(n));

    }
}
